package com.amsidh.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.doms.EmployeeDom;
import com.amsidh.dtos.EmployeeDto;
import com.amsidh.service.EmployeeService;
import com.amsidh.service.impl.EmployeeServiceImpl;

public class EmpApplication {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring/spring-service-context.xml");

		EmpApplication empApplication = new EmpApplication();
		EmployeeDto employee = new EmployeeDto();
		employee.setEmpName("Amsidh");
		
		empApplication.employeeService=(EmployeeService)context.getBean("employeeService");
		empApplication.employeeService.removeEmployee(employee);
		/*List<EmployeeDto> listOfEmpDtos = empApplication.employeeService
				.getAllEmployee();
		for (EmployeeDto emp : listOfEmpDtos) {
			System.out.println(emp.getEmpId() + "   " + emp.getEmpName());
		}*/
		EmployeeDto ee=new EmployeeDto();
		ee.setEmpName("Amsidh");
		EmployeeDto emp=empApplication.employeeService.searchEmployee(ee);
		System.out.println(emp.getEmpId()+"   :   "+emp.getEmailId());
		

	}
}
