package com.example.restapiwithmockdata.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class StudentRegistration {

	List<Student> studentList;

	public StudentRegistration() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student(25, "Rishabh", "RSPL1"));
		studentList.add(new Student(20, "Vikash", "RSPL2"));
		studentList.add(new Student(28, "Rehan", "RSPL3"));
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public Optional<Student> getStudentByRegNo(Student student) {
		return studentList.stream().filter(stud -> stud.equals(student))
				.findFirst();
	}

	public Optional<List<Student>> getAllStudent() {
		return Optional.of(studentList);
	}

	public Optional<Student> deleteStudentByRegNo(Student student) {
		if(studentList.remove(student))
			return Optional.of(student);
		else
			return Optional.empty();
		
	}
	
	public Optional<Student> editStudent(Student stud) {
		
		Optional<Student> optional = studentList.stream().filter(student -> student.equals(stud)).findFirst().map(student -> {
			student.setAge(stud.getAge());
			student.setName(stud.getName());
			return student;
		});
		
		return optional;
	}

}
