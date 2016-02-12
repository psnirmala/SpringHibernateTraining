package com.genpact.training.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name implements Serializable {
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
