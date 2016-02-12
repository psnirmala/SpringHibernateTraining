package com.genpact.training.onetoonebidirectional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneBidirectionalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
	/*Customer customer1=new Customer(1, "Rajesh", 6000);
	customer1.setAddress(new Address(1001, "Hebbal", "Bangalore"));
		Customer customer2=new Customer(2, "Deva", 3000);
		customer2.setAddress(new Address(1002, "Bandra East", "Mumbai"));
		Transaction tx=session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		tx.commit();
		System.out.println("rows added");*/
		
		Query query=session.createQuery("from Address");
		List<Address> addresses=query.list();
		for(Address address:addresses){
			System.out.println(address.getLocation()+"\t"+address.getCity()+"\t"+address.getCustomer().getName());
		}
		
		/*Query query=session.createQuery("select c.id,c.name from Customer as c");
		List<Object[]> list=query.list();
		for(Object[] array:list){
			System.out.println(array[0]+" "+array[1]);
		}*/

	}

}
