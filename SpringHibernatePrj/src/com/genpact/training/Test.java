package com.genpact.training;

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
		CustomerDAO dao=(CustomerDAO)context.getBean("customerDAO");
		dao.addCustomer(new Customer(10, "Rajiv", 1300));
		/*dao.addCustomer(new Customer(2, "Deva", 8000));
		List<Customer> customers=dao.getAllCustomers();
		for(Customer customer:customers){
			System.out.println(customer.getId()+"\t"+customer.getName()+"\t"+customer.getBalance());
		}*/
	}

}
