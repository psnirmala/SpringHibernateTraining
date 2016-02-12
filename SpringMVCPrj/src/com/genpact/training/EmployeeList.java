package com.genpact.training;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EmployeeList {
	private Map<Integer, Employee> map=new HashMap<>();
	
	public EmployeeList()
	{
		map.put(1, new Employee(1, "Rajiv", "Developer"));
		map.put(2, new Employee(2, "Deva", "Accountant"));
		map.put(3, new Employee(3, "Arjun", "Developer"));
	}

	public Employee findEmployee(int id)
	{
		return map.get(id);
	}
}
