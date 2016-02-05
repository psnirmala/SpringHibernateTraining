package com.genpact.training;

import java.util.List;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("beans2.xml");
		Company company=(Company)context.getBean("comp");
		System.out.println("Name:"+company.getName());
		Properties props=company.getProperties();
		props.list(System.out);
		
		
	}

}
