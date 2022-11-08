package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.concretepage.entity.Student;

@Component
public interface StudentService {
	public Student save(Student student);

	public Student update(Student student);

	public Student get(int id);

	public void delete(Student student);
	List<Student> getStudent();
}
