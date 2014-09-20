package com.flyingh.jpa.service;

import java.util.List;

import com.flyingh.jpa.vo.Person;

public interface PersonService {
	void add(Person person);

	void update(Person person);

	void delete(int id);

	Person find(int id);

	List<Person> findAll();
}
