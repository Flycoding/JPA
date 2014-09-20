package com.flyingh.jpa.service.impl;

import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.flyingh.jpa.service.StudentService;
import com.flyingh.jpa.vo.Book;
import com.flyingh.jpa.vo.Student;

public class StudentServiceImplTest {
	private StudentService studentService;

	@Before
	public void before() {
		studentService = new StudentServiceImpl(Persistence.createEntityManagerFactory("JPA").createEntityManager());
	}

	@Test
	public void testAdd() {
		final Student student = new Student("Flycoding");
		student.addBook(new Book("Java"));
		studentService.add(student);
	}
}
