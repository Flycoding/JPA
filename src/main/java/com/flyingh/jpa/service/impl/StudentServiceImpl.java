package com.flyingh.jpa.service.impl;

import javax.persistence.EntityManager;

import com.flyingh.jpa.service.StudentService;
import com.flyingh.jpa.vo.Student;

public class StudentServiceImpl implements StudentService {
	private final EntityManager em;

	public StudentServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

}
