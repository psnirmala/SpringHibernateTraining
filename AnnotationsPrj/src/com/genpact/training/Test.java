package com.genpact.training;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
	Customer customer1=new Customer(1, "Rajesh", 6000);
		Customer customer2=new Customer(2, "Deva", 3000);
		Transaction tx=session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		System.out.println("rows added");
		
		/*Query query=session.createQuery("from Customer");
		List<Customer> customers=query.list();
		for(Customer customer:customers){
			System.out.println(customer.getId()+"\t"+customer.getName()+"\t"+customer.getBalance());
		}*/
		
		/*Query query=session.createQuery("select c.id,c.name from Customer as c");
		List<Object[]> list=query.list();
		for(Object[] array:list){
			System.out.println(array[0]+" "+array[1]);
		}*/

	}

}
