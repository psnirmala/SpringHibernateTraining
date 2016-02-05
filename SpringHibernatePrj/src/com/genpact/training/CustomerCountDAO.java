package com.genpact.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerCountDAO {
	@Autowired
	private HibernateTemplate template;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void increment()
	{
		CustomerCount customerCount=template.get(CustomerCount.class, "no_of_customers");
		customerCount.setCount(customerCount.getCount()+1);
	}
	
	

}
