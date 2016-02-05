package com.genpact.training.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {
	@Autowired
	private JdbcTemplate template;
	
	public int addEmployee(int id,String name,String designation,double salary)
	{
		String sql="insert into Employee_TBL values(?,?,?,?)";
		int rowsUpdated=template.update(sql, id,name,designation,salary);
		return rowsUpdated;
	}
	
	public int deleteEmployee(int id)
	{
		String sql="delete from Employee_TBL where emp_id=?";
		int rowsDeleted=template.update(sql, id);
		return rowsDeleted;
	}
	
	public Employee findEmployee(int id)
	{
		String sql="select * from Employee_TBL where emp_id=?";
		Employee employee=template.queryForObject(sql, new EmployeeRowMapper(), id);
		return employee;
	}
	
	public List<Employee> findAllEmployees()
	{
		String sql="select * from Employee_TBL";
		List<Employee> employees=template.query(sql, new EmployeeRowMapper());
		return employees;
	}
	public List<Employee> findEmployeeByDesignation(String designation)
	{
		String sql="select * from Employee_TBL where designation=?";
		List<Employee> employees=template.query(sql, new EmployeeRowMapper(),designation);
		return employees;
	}

}
