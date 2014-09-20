package com.flyingh.jpa.vo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Person {
	private Integer id;
	private String name;
	private Date birthday;
	private Gender gender = Gender.MALE;
	private String desc;
	private byte[] file;
	private String path;
	private IdCard idCard;

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(String name, Date birthday, Gender gender) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Person(String name, Date birthday, Gender gender, String desc, byte[] file, String path) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.desc = desc;
		this.file = file;
		this.path = path;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 6, nullable = false)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Lob
	@Column(name = "description")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Transient
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		idCard.setPerson(this);
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
}
