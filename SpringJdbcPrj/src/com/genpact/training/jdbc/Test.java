package com.genpact.training.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO dao=(EmployeeDAO) context.getBean("employeeDAO");
		List<Employee> list=dao.findAllEmployees();
		for(Employee e:list){
			System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getDesignation());
		}
	}

}
