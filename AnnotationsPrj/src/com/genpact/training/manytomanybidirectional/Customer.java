package com.genpact.training.manytomanybidirectional;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cust_manytomanybirectional_tbl")
public class Customer {
	@Id
	@Column(name="cust_id")
	private int id;
	@Column(name="cust_name")
	private String name;
	private double balance;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="cust_add_tbl",joinColumns=@JoinColumn(name="customer_id"),
	inverseJoinColumns=@JoinColumn(name="address_id"))
	private Set<Address> addresses;
	
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
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
	

}
