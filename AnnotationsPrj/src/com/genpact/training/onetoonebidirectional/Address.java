package com.genpact.training.onetoonebidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_onetoonebidirectional_tbl")
public class Address {
	@Id
	@Column(name="address_id")
	private int id;
	private String location;
	private String city;
	//address in mappedBy attribute is the variable name declared in Customer class
	@OneToOne(mappedBy="address")
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(int id, String location, String city) {
		super();
		this.id = id;
		this.location = location;
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
