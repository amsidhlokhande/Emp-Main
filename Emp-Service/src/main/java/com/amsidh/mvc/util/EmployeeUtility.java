package com.amsidh.mvc.util;

import com.amsidh.mvc.entity.EmployeeDom;
import com.amsidh.mvc.model.EmployeeDto;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtility {

	public static EmployeeDom getEmployeeDom(EmployeeDto employeeDto) {
		EmployeeDom employeeDom = new ModelMapper().map(employeeDto, EmployeeDom.class);
		return employeeDom;
	}

	public static EmployeeDto getEmployeeDto(EmployeeDom employeeDom) {
		EmployeeDto employeeDto = new ModelMapper().map(employeeDom, EmployeeDto.class);
		return employeeDto;
	}

	public static List<EmployeeDom> getEmployeeDoms(List<EmployeeDto> employeeDtos) {
		List<EmployeeDom> listOfEmployeeDoms = new ArrayList<EmployeeDom>();
		for (EmployeeDto employeeDto : employeeDtos) {
			listOfEmployeeDoms.add(getEmployeeDom(employeeDto));
		}
		return listOfEmployeeDoms;
	}

	public static List<EmployeeDto> getEmployeeDtos(List<EmployeeDom> employeeDoms) {
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		for (EmployeeDom employeeDom : employeeDoms) {
			employeeDtos.add(getEmployeeDto(employeeDom));
		}
		return employeeDtos;
	}
}
