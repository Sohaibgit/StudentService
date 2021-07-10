package com.softdev.controller;

import com.softdev.entity.Student;
import com.softdev.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	private List<Student> students;

	@PostConstruct
	public void loadStudentsList() {
		students = new ArrayList<Student>();

		students.add(new Student("Aslam", "Khan"));
		students.add(new Student("Akram", "Khan"));
		students.add(new Student("Danial", "Khan"));
		students.add(new Student("Ammar", "Khan"));
		students.add(new Student("Mehroz", "Khan"));
	}

	@GetMapping
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("student id not found - " + studentId);
		}

		return students.get(studentId);
	}

	

}
