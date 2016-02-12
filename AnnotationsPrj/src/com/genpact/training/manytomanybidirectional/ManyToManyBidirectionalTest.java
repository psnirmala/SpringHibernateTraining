package com.genpact.training.manytomanybidirectional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyBidirectionalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
	/*Customer customer1=new Customer(1, "Rajesh", 6000);
	Customer customer2=new Customer(2, "Deva", 3000);
	
	Address address1=new Address(1001, "Bellandur", "Bangalore");
	Address address2=new Address(1002, "Malad East", "Mumbai");
	Address address3=new Address(1003, "Ameerpet", "Hyderabad");
	Address address4=new Address(1004, "T Nagar", "Chennai");
	
	
	Set<Address> set1=new HashSet<>();
	set1.add(address1);
	set1.add(address2);
	set1.add(address4);
	
	Set<Address> set2=new HashSet<>();
	set2.add(address3);
	set2.add(address4);
	set2.add(address2);
	
	
	customer1.setAddresses(set1);
	customer2.setAddresses(set2);
		
		Transaction tx=session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		System.out.println("rows added");
	*/
		Query query=session.createQuery("from Address");
		List<Address> addresses=query.list();
		for(Address address:addresses){
			System.out.println(address.getLocation()+"\t"+address.getCity());
			System.out.println("Customers who belong to this address");
			Set<Customer> set=address.getCustomers();
			for(Customer c:set){
				System.out.println(c.getId()+"\t"+c.getName());
			}
		}
		
		System.out.println("retrieving through customer");
		 query=session.createQuery("from Customer");
		List<Customer> customers=query.list();
		for(Customer customer:customers){
			System.out.println(customer.getId()+"\t"+customer.getName()+"\t"+customer.getBalance());
			System.out.println("Addresses of this customer");
			Set<Address> set=customer.getAddresses();
			for(Address address:set){
				System.out.println(address.getLocation()+"\t"+address.getCity());
			}
		}
		
		/*Query query=session.createQuery("select c.id,c.name from Customer as c");
		List<Object[]> list=query.list();
		for(Object[] array:list){
			System.out.println(array[0]+" "+array[1]);
		}*/

	}

}
