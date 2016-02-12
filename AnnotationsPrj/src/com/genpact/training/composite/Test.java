package com.genpact.training.composite;

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
		Person person1=new Person(new Name("John", "Richard"), "Male", 25);
		Person person2=new Person(new Name("John", "David"), "Male", 28);
		Person person3=new Person(new Name("Jenny", "Richard"), "Female", 22);
	Transaction tx=session.beginTransaction();
	session.save(person1);
	session.save(person2);
	session.save(person3);
	tx.commit();
	
		

	}

}
