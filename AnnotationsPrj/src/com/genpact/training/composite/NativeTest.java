package com.genpact.training.composite;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NativeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		String sql="select * from customer_tbl";
		Query query=session.createSQLQuery(sql);
		List<Object[]> list=query.list();
		for(Object[] array:list){
			System.out.println(array[0]+" "+array[1]+" "+array[2]);
		}
	
	
		

	}

}
