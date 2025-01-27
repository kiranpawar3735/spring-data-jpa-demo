package com.kiran.spring_data_jpa_demo.entitymanager_demo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Employee employee) {
		entityManager.merge(employee);
	}

	public Employee update(Employee employee) {
		return entityManager.merge(employee);
	}

	public Employee findById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> findAll() {
		String getAll = "SELECT e from Employee e";
		Query query = entityManager.createQuery(getAll);
		return query.getResultList();
	}

	public void deleteById(Integer id) {
		Employee employee = this.findById(id);
		entityManager.remove(employee);
	}
}