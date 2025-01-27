package com.kiran.spring_data_jpa_demo.jdbc_template;



public class Person {
	private Integer personId;
	private String name;

	public Person(Integer personId, String name) {
		super();
		this.personId = personId;
		this.name = name;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}