package com.flyingh.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flyingh.jpa.vo.Employee;
import com.flyingh.jpa.vo.Manager;
import com.flyingh.jpa.vo.Saleman;

public class InheritanceTest {
	private EntityManager em;

	@Before
	public void before() {
		em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	}

	@Test
	public void test() {
		final Employee employee = new Employee("A");
		final Manager manager = new Manager("B");
		final Saleman saleman = new Saleman("C");
		em.getTransaction().begin();
		em.persist(employee);
		em.persist(manager);
		em.persist(saleman);
		em.getTransaction().commit();
	}

	@After
	public void after() {
		em.close();
		em = null;
	}
}
