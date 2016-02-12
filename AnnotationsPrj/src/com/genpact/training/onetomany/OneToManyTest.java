package com.genpact.training.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
	Customer customer1=new Customer(1, "Rajesh", 6000);
	Set<Address> set1=new HashSet<>();
	set1.add(new Address(1001, "Bellandur", "Bangalore"));
	set1.add(new Address(1002, "Hinjewadi", "Pune"));
	customer1.setAddresses(set1);
	
		Customer customer2=new Customer(2, "Deva", 3000);
		Set<Address> set2=new HashSet<>();
		set2.add(new Address(1003, "Punjakutta", "Hyderabad"));
		set2.add(new Address(1004, "Sector-17", "Noida"));
		
		customer2.setAddresses(set2);
		
		Transaction tx=session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		System.out.println("rows added");
		
		/*Query query=session.createQuery("from Customer");
		List<Customer> customers=query.list();
		for(Customer customer:customers){
			System.out.println(customer.getId()+"\t"+customer.getName()+"\t"+customer.getBalance()+"\t"+
					customer.getAddress().getLocation()+"\t"+customer.getAddress().getCity());
		}
		
		/*Query query=session.createQuery("select c.id,c.name from Customer as c");
		List<Object[]> list=query.list();
		for(Object[] array:list){
			System.out.println(array[0]+" "+array[1]);
		}*/

	}

}
