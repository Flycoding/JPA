package com.flyingh.jpa.service.impl;

import java.util.Date;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flyingh.jpa.service.PersonService;
import com.flyingh.jpa.vo.Gender;
import com.flyingh.jpa.vo.IdCard;
import com.flyingh.jpa.vo.Person;

public class PersonServiceImplTest {
	private PersonService personService;

	@Before
	public void setUp() throws Exception {
		personService = new PersonServiceImpl(Persistence.createEntityManagerFactory("JPA").createEntityManager());
	}

	@Test
	public void testAdd() {
		final Person person = new Person("Flyingh", new Date(), Gender.MALE);
		person.setIdCard(new IdCard("abcde"));
		personService.add(person);
	}

	@Test
	public void testUpdate() {
		personService.update(new Person(1, "Flycoding"));
	}

	@Test
	public void testDelete() {
		personService.delete(2);
	}

	@Test
	public void testFind() {
		System.out.println(personService.find(1));
	}

	@Test
	public void testFindAll() {
		personService.findAll().forEach(System.out::println);
	}

	@After
	public void tearDown() throws Exception {
		personService = null;
	}

}
