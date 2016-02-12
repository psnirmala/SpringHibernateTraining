package com.genpact.training.composite;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Person_TBL")
public class Person {
	@EmbeddedId
	private Name name;
	private String gender;
	private int age;
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(Name name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
