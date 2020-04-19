package com.amsidh.dao;

import java.util.List;

import com.amsidh.dtos.EmployeeDto;

public interface EmployeeDao {
	public String createEmployee(EmployeeDto employee);

	public String removeEmployee(EmployeeDto employee);

	public EmployeeDto updateEmployee(EmployeeDto employee);

	public EmployeeDto searchEmployee(EmployeeDto employee);

	public List<EmployeeDto> getAllEmployee();
}
