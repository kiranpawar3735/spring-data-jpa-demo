package com.kiran.spring_data_jpa_demo.entitymanager_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerCommandLineRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee(1, "James", 999_999.00);
		employeeRepository.save(employee);

		employee.setName("Romeo");
		Employee updatedEmployee = employeeRepository.update(employee);
		System.out.println("Updated Employee: " + updatedEmployee);

		Employee employee2 = employeeRepository.findById(1);
		System.out.println("Found Employee: " + employee2);

		List<Employee> employees = employeeRepository.findAll();
		System.out.println("All Employees: " + employees);

		employeeRepository.deleteById(1);
	}
}