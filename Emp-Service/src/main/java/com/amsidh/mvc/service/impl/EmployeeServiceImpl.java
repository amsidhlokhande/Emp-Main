package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.EmployeeDom;
import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.repository.EmployeeRepository;
import com.amsidh.mvc.service.EmployeeService;
import com.amsidh.mvc.util.EmployeeUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Transactional
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		EmployeeDom employeeDom = employeeRepository.save(EmployeeUtility.getEmployeeDom(employeeDto));
		return EmployeeUtility.getEmployeeDto(employeeDom);

	}

	@Transactional
	@Override
	public void removeEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Transactional
	@Override
	public EmployeeDto updateEmployee(Integer employeeId,EmployeeDto employeeDto) {
		EmployeeDom employeeDom = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not found wih id " + employeeId));
		if (employeeDom != null) {
			employeeDom.setCompanyName(employeeDto.getCompanyName());
			employeeDom.setEmpName(employeeDto.getEmpName());
			employeeDom.setMobileNumber(employeeDto.getMobileNumber());
			employeeDom.setEmailId(employeeDto.getEmailId());
			employeeDom.setAddress(employeeDto.getAddress());
		}
		employeeRepository.flush();
		return EmployeeUtility.getEmployeeDto(employeeDom);
	}

	@Override
	public EmployeeDto searchEmployeeById(Integer employeeId) {
		return EmployeeUtility.getEmployeeDto(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not found wih id " + employeeId)));
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		return EmployeeUtility.getEmployeeDtos(employeeRepository.findAll());
	}

}
