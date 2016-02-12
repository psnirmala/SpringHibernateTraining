package com.genpact.training.onetomanybidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_onetomanybirectional_tbl")
public class Address {
	@Id
	@Column(name="address_id")
	private int id;
	private String location;
	private String city;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id")
	private Customer cust;
	
	
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
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
