package com.amsidh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.dtos.EmployeeDto;
import com.amsidh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public String createEmployee(EmployeeDto employee) {
		return employeeDao.createEmployee(employee);

	}

	public String removeEmployee(EmployeeDto employee) {
		return employeeDao.removeEmployee(employee);

	}

	public EmployeeDto updateEmployee(EmployeeDto employee) {

		return employeeDao.updateEmployee(employee);
	}

	public EmployeeDto searchEmployee(EmployeeDto employee) {

		return employeeDao.searchEmployee(employee);
	}

	public List<EmployeeDto> getAllEmployee() {

		return employeeDao.getAllEmployee();
	}

}
