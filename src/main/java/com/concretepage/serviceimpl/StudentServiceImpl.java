package com.concretepage.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Student;
import com.concretepage.repository.StudentRepository;
import com.concretepage.service.StudentService;

@Service("bookServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	@CachePut(value = "student", key = "#student.id")
	public Student save(Student student) {
		Student createResponse = studentRepository.save(student);
		return createResponse;
	}

	@Transactional
	@Cacheable(value = "student", key = "#id")
	public Student get(int id) {
		Student student = null;
		Optional<Student> studentResponse = studentRepository.findById(id);
		if (studentResponse.isPresent()) {
			student = studentResponse.get();
		} else {
			throw new RuntimeException("Record not found");
		}
		return student;
	}

	@Transactional
	@CachePut(value = "student", key = "#student.id")
	public Student update(Student student) {
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}

	@Transactional
	@CacheEvict(value = "student", key = "#student.id")
	public void delete(Student student) {
		studentRepository.delete(student);
	}
	@Transactional
	@Override
	public List<Student> getStudent() {
		List<Student> lisStudents = (List<Student>) studentRepository.findAll();
		return  lisStudents;
	}
	
}
