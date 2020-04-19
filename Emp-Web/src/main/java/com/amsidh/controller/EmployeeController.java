package com.amsidh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amsidh.dtos.EmployeeDto;
import com.amsidh.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String mainPage(Map<String,Object> map) {
		map.put("employee", new EmployeeDto());
		map.put("employeeList", employeeService.getAllEmployee());
		return "employee";
	}

	@RequestMapping(value = "/action.do", method = RequestMethod.POST)
	public String actions(@ModelAttribute("employee") EmployeeDto employee,
			BindingResult result, @RequestParam("myAction") String myAction,Map<String,Object> map) {
		
		EmployeeDto employeeResult = new EmployeeDto();
		String message="";  
		if (myAction.equals("add")) {
			message= employeeService.createEmployee(employee);
			employeeResult = employee;
		}
		if (myAction.equals("update")) {
			employeeService.updateEmployee(employee);
			employeeResult = employee;
		}
		if (myAction.equals("delete")) {
			message=employeeService.removeEmployee(employee);
			employeeResult = employee;
		}
		if (myAction.equals("search")) {
			EmployeeDto searchEmployee = employeeService
					.searchEmployee(employee);
			employeeResult = searchEmployee != null ? searchEmployee
					: new EmployeeDto();
		}
		
		map.put("employee", employeeResult);
		map.put("employeeList", employeeService.getAllEmployee());
		map.put("message", message);
		return "employee";
	}

}
