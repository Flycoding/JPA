package com.flyingh.jpa.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();

	public Teacher() {
		super();
	}

	public Teacher(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 22, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "teachers")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		for (final Student student : students) {
			student.getTeachers().add(this);
		}
		this.students = students;
	}

}
