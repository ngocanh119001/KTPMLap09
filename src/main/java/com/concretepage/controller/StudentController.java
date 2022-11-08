package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concretepage.entity.Student;
import com.concretepage.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		Student createResponse = studentService.save(student);
		return createResponse;
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		Student updateResponse = studentService.update(student);
		return updateResponse;
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		Student getReponse = studentService.get(id);
		return getReponse;
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody Student student) {
		studentService.delete(student);
		return "Record deleted succesfully";
	}
	@GetMapping("/list")
	public List<Student> getList() {
		List<Student> list = studentService.getStudent();
		return list;
	}
}