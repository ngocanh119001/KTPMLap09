package com.concretepage.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student,Serializable> {
//	public List<Student> findByStuden();
}
