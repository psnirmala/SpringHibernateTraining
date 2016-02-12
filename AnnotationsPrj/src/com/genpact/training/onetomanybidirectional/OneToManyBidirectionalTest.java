package com.genpact.training.onetomanybidirectional;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyBidirectionalTest {

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
	
	address1.setCust(customer1);
	address2.setCust(customer1);
	
	address3.setCust(customer2);
	address4.setCust(customer2);
		
		Transaction tx=session.beginTransaction();
		session.save(address1);
		session.save(address2);
		session.save(address3);
		session.save(address4);
		tx.commit();
		System.out.println("rows added");
	*/
		Query query=session.createQuery("from Address");
		List<Address> addresses=query.list();
		for(Address address:addresses){
			System.out.println(address.getLocation()+"\t"+address.getCity()+"\t"+address.getCust().getName());
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
