package com.flyingh.jpa.vo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Saleman extends Employee {
	public Saleman() {

	}

	public Saleman(String name) {
		super(name);
	}

}
