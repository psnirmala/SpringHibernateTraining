package com.genpact.training.manytomanybidirectional;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("balance", 3000));
		List<Customer> list=criteria.list();
		for(Customer customer:list){
			System.out.println(customer.getId()+" "+customer.getName()+" "+customer.getBalance());
		}

	}

}
