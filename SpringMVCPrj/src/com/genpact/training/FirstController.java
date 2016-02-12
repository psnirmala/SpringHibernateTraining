package com.genpact.training;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	
	@Autowired
	private EmployeeList employeeList;
	@RequestMapping("/first.req")
	public String messageRequest(Map<String, Object> model)
	{
		model.put("message", "Welcome to Spring MVC");
		return "showMessage";
		
	}
	
	@RequestMapping("/emp.req")
	public String getEmployeeDetails(Map<String, Object> model,@RequestParam("emp_id")int empId)
	{
		model.put("emp", employeeList.findEmployee(empId));
		return "showEmployee";
	}

}
