package com.example.restapiwithmockdata.vo;

public class Student {

	private Integer age;
	private String name;
	private String registrationNumber;

	public Student(String registrationNumber) {
		super();
		this.registrationNumber = registrationNumber;
	}

	public Student(Integer age, String name, String registrationNumber) {
		super();
		this.age = age;
		this.name = name;
		this.registrationNumber = registrationNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public boolean equals(Object obj) {
		Student stud = (Student) obj;
		if (this.registrationNumber.equals(stud.getRegistrationNumber()))
			return true;
		else
			return false;
	}

}
