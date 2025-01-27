package com.kiran.spring_data_jpa_demo.jdbc_template;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component // remove comment for execution
public class JdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person(1, "Ramesh");

		personRepository.savePerson(person);
		System.out.println("Query executed successfully.");

		personRepository.updatePerson(new Person(1, "Suresh"));

		System.out.println(personRepository.findById(1));
		System.out.println(personRepository.findAll());

		personRepository.deleteById(1);
	}

}