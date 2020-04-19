package com.amsidh.util;

import java.util.ArrayList;
import java.util.List;

import com.amsidh.doms.EmployeeDom;
import com.amsidh.dtos.EmployeeDto;

public class DomDaoCreatorUtil {

	public static EmployeeDom getEmployeeDom(EmployeeDto employeeDto) {
		EmployeeDom employeeDom = new EmployeeDom();
		employeeDom.setEmpId(employeeDto.getEmpId());
		employeeDom.setEmpName(employeeDto.getEmpName());
		employeeDom.setJoiningDate(employeeDto.getJoiningDate());
		employeeDom.setMobileNumber(employeeDto.getMobileNumber());
		employeeDom.setAddress(employeeDto.getAddress());
		employeeDom.setCompanyName(employeeDto.getCompanyName());
		employeeDom.setEmailId(employeeDto.getEmailId());
		return employeeDom;
	}
	
	public static EmployeeDto getEmployeeDto(EmployeeDom employeeDom) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpId(employeeDom.getEmpId());
		employeeDto.setEmpName(employeeDom.getEmpName());
		employeeDto.setJoiningDate(employeeDom.getJoiningDate());
		employeeDto.setMobileNumber(employeeDom.getMobileNumber());
		employeeDto.setAddress(employeeDom.getAddress());
		employeeDto.setCompanyName(employeeDom.getCompanyName());
		employeeDto.setEmailId(employeeDom.getEmailId());
		return employeeDto;
	}
	
	public static List<EmployeeDom> getEmployeeDoms(List<EmployeeDto> employeeDtos) {
		List<EmployeeDom> listOfEmployeeDoms=new ArrayList<EmployeeDom>();
		for(EmployeeDto employeeDto:employeeDtos)
		{
		listOfEmployeeDoms.add(getEmployeeDom(employeeDto));
		}
		return listOfEmployeeDoms;
	}
	
	public static List<EmployeeDto> getEmployeeDtos(List<EmployeeDom> employeeDoms) {
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		for(EmployeeDom employeeDom:employeeDoms)
		{
		employeeDtos.add(getEmployeeDto(employeeDom));
		}
		return employeeDtos;
	}
}
