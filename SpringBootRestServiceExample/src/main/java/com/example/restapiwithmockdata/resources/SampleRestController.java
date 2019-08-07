package com.example.restapiwithmockdata.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapiwithmockdata.vo.Student;
import com.example.restapiwithmockdata.vo.StudentRegistration;

@RestController
public class SampleRestController {

	@Autowired
	private StudentRegistration studRegistration;
	private String message = "No Record found for Student Details";


	/**
	 * 
	 * http GET method to get all students details
	 * @return
	 */
	@GetMapping(value = "/studentsData")
	public ResponseEntity<Object> getData() {
		Optional<List<Student>> optinal= studRegistration.getAllStudent();
		if(optinal.isPresent())
			return new ResponseEntity<Object>(optinal,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Records Available.",HttpStatus.OK);
	}

	@PostMapping(value = "/student")
	public ResponseEntity<Object> addStudent(@RequestBody Student student){
		studRegistration.addStudent(student);
		return new ResponseEntity<Object>(studRegistration.getAllStudent(),HttpStatus.OK);
	}
	/**
	 * 
	 * http GET method to get student details by student registration number
	 * @param studRegNo
	 * @return
	 */
	@GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudent(@RequestParam(name = "regNo") String studRegNo) {
		Optional<Student> student = studRegistration.getStudentByRegNo(new Student(studRegNo));

		if (student.isPresent())
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		else
			return new ResponseEntity<Object>(message, HttpStatus.OK);

	}

	/**
	 * 
	 * http DELETE method to delete student details by student registration number
	 * @param studRegNo
	 * @return
	 */
	@DeleteMapping(value = "/student")
	public ResponseEntity<Object> deleteStudent(@RequestParam(name = "regNo") String studRegNo) {
		Optional<Student> optional = studRegistration.deleteStudentByRegNo(new Student(studRegNo));
		if (optional.isPresent())
			return new ResponseEntity<Object>(studRegistration.getAllStudent(), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Record found to Delete Student Details", HttpStatus.OK);

	}

	/**
	 *
	 * http PUT method to edit student details
	 * @param student
	 * @return
	 */
	@PutMapping(value = "/student")
	public ResponseEntity<Object> editStudent(@RequestBody Student student) {

		Optional<Student> optional = studRegistration.editStudent(student);

		if (optional.isPresent())
			return new ResponseEntity<Object>(studRegistration.getAllStudent(), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Record found to Update Student Details", HttpStatus.OK);

	}

}
