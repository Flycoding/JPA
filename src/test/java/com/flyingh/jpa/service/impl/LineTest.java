package com.flyingh.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.flyingh.jpa.vo.Line;
import com.flyingh.jpa.vo.Line.PK;

public class LineTest {
	private EntityManager em;

	@Before
	public void before() {
		em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	}

	@Test
	public void test() {
		em.getTransaction().begin();
		em.persist(new Line(new PK("A", "B"), "A->B"));
		em.getTransaction().commit();
		em.close();
	}
}
