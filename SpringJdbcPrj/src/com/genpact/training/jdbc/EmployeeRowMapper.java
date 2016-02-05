package com.genpact.training.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class EmployeeRowMapper implements ParameterizedRowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setDesignation(rs.getString(3));
		employee.setSalary(rs.getDouble(4));
		return employee;
	}

}
