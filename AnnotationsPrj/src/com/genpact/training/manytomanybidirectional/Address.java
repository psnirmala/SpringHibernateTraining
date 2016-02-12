package com.genpact.training.manytomanybidirectional;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_manytomanybirectional_tbl")
public class Address {
	@Id
	@Column(name="address_id")
	private int id;
	private String location;
	private String city;
	
	@ManyToMany(mappedBy="addresses")
	private Set<Customer> customers;
	
			
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
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
	
	
	

}
