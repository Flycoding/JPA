package com.flyingh.jpa.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.flyingh.jpa.service.StudentService;
import com.flyingh.jpa.vo.Book;
import com.flyingh.jpa.vo.Student;
import com.flyingh.jpa.vo.Teacher;

public class StudentServiceImplTest {
	private StudentService studentService;
	private EntityManager em;

	@Before
	public void before() {
		em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		studentService = new StudentServiceImpl(em);
	}

	@Test
	public void testAdd() {
		final Student student = new Student("Flycoding");
		student.addBook(new Book("Java"));
		studentService.add(student);
	}

	@Test
	public void add() {
		em.getTransaction().begin();
		final Student student = new Student("flyingh");
		final Teacher teacher = new Teacher("A");
		final Teacher teacher2 = new Teacher("B");
		student.setTeachers(new HashSet<Teacher>(Arrays.asList(teacher, teacher2)));
		em.persist(teacher);
		em.persist(teacher2);
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}
}
