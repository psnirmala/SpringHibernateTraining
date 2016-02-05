package com.genpact.training;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Count_TBL")
public class CustomerCount {
	@Id
	private String detail;
	private int count;
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CustomerCount(String detail, int count) {
		super();
		this.detail = detail;
		this.count = count;
	}
	public CustomerCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
