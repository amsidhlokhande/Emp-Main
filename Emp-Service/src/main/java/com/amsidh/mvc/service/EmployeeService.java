package com.amsidh.mvc.service;

import com.amsidh.mvc.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employee);

	void removeEmployee(Integer employeeId);

	EmployeeDto updateEmployee(Integer employeeId, EmployeeDto employee);

	EmployeeDto searchEmployeeById(Integer employeeId);

	List<EmployeeDto> getAllEmployee();
}
