package com.kiran.spring_data_jpa_demo.jdbc_template;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String SAVE = """
			INSERT into Person(person_id, name)
			values(?, ?);
			""";

	private String UPDATE = """
			UPDATE person SET name = ? where person_id = ?;
			""";

	private String GET_BY_ID = """
			SELECT * from Person where person_id =?;
			""";
	private String GET_ALL = """
			SELECT * from Person;
			""";

	private String DELETE = """
			DELETE from person where person_id = ?;
			""";

	public void savePerson(Person person) {
		jdbcTemplate.update(SAVE, person.getPersonId(), person.getName());
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update(UPDATE, person.getName(), person.getPersonId());
	}

	public List<Person> findById(Integer id) {
		return jdbcTemplate.query(GET_BY_ID, new BeanPropertyRowMapper<>(Person.class), id);
	}

	public List<Person> findAll() {
		System.out.println("Retrieving all");
		return jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Person.class));
	}

	public int deleteById(Integer id) {
		return jdbcTemplate.update(DELETE, id);
	}
}