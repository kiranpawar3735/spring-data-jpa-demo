package com.kiran.spring_data_jpa_demo.spring_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book(1, "Art of War", "Deutch Arnold");
		
		System.out.println(bookRepository.save(book));
		System.out.println(bookRepository.findAll());
		System.out.println(bookRepository.findById(1));
		bookRepository.deleteById(1);
	}
}