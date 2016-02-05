package com.genpact.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Employee employee=(Employee)context.getBean("emp");
		System.out.println(employee.getEmpId()+"\t"+employee.getEmpName()+
					"\t"+employee.getDesignation());
		Address address=employee.getAddress();
		System.out.println(address.getLocation()+"\t"+address.getCity());
	}

}
