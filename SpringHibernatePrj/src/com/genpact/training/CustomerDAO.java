package com.genpact.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerDAO {
	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private CustomerCountDAO customerCountDAO;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addCustomer(Customer c)
	{
		template.save(c);
		customerCountDAO.increment();
		if(c.getBalance()<1000){
		throw new RuntimeException("Less than minimum balance "+c.getBalance());
		}
	}
	public List<Customer> getAllCustomers()
	{
		return template.find("from Customer");
	}
	
	public List<Customer> findCustomersByBalance(double balance)
	{
		String query="select c from Customer as c where c.balance=?";
		List<Customer> customers=template.find(query, balance);
		return customers;
	}
	public Customer findCustomer(int id)
	{
		return template.get(Customer.class, id);
	}
	

}
