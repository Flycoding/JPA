package com.flyingh.jpa.vo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Manager extends Employee {
	public Manager() {

	}

	public Manager(String name) {
		super(name);
	}
}
