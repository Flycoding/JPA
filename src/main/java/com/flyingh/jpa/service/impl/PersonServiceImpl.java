package com.flyingh.jpa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.flyingh.jpa.service.PersonService;
import com.flyingh.jpa.vo.Person;

public class PersonServiceImpl implements PersonService {

	private final EntityManager em;

	public PersonServiceImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void add(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}

	@Override
	public void update(Person person) {
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		em.remove(em.getReference(Person.class, id));
		em.getTransaction().commit();
	}

	@Override
	public Person find(int id) {
		return em.find(Person.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {
		return em.createQuery("from Person").getResultList();

	}

}
