package com.genpact.training;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String location="MG Road";
	private String city="Bangalore";
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
	
	

}
