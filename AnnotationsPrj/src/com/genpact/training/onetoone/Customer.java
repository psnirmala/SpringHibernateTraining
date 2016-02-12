package com.genpact.training.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cust_onetoone_tbl")
public class Customer {
	@Id
	@Column(name="cust_id")
	private int id;
	@Column(name="cust_name")
	private String name;
	private double balance;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="add_id")
	private Address address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
