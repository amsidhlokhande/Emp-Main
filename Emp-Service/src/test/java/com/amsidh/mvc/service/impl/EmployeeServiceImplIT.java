package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.EmployeeDom;
import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.repository.EmployeeRepository;
import com.amsidh.mvc.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.amsidh.mvc.util.EmployeeUtility.getEmployeeDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ActiveProfiles("test")
@DataJpaTest
public class EmployeeServiceImplIT {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Before
    public void setup() {
        this.employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(employeeRepository).isNotNull();
    }

    @Test
    public void testCreateEmployee() {
        EmployeeDto employeeDto = loadEmployeeToDatabase();
        assertNotNull(employeeDto);
        assertNotNull(employeeDto.getEmpId());
    }

    @Test
    public void testSearchEmployeeById() {
        //First load the employee to the database
        EmployeeDto employee = loadEmployeeToDatabase();
        //Then Search the employee with above newly created employee's id
        EmployeeDto searchEmployee = this.employeeService.searchEmployeeById(employee.getEmpId());
        assertNotNull(searchEmployee);
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveEmployeeById() {
        //First load the employee to the database
        EmployeeDto employee = loadEmployeeToDatabase();

        //Now delete the employee loaded in above step
        this.employeeService.removeEmployee(employee.getEmpId());
        //For assertion search above employee this time you will get java.lang.RuntimeException: Employee Not found wih id
        this.employeeService.searchEmployeeById(employee.getEmpId());
    }

    @Test
    public void testUpdateEmployee() {
        //First load the employee to the database
        EmployeeDto employee = loadEmployeeToDatabase();
        //Update employee loaded in above step
        EmployeeDto updateEmployee = getEmployeeDto(getEmployeeDom());
        updateEmployee.setEmpName("Updated Name");
        updateEmployee.setCompanyName("Updated Company");
        EmployeeDto employeeDto = this.employeeService.updateEmployee(employee.getEmpId(), updateEmployee);

        assertNotNull(employeeDto);
        assertEquals(employeeDto.getEmpName(), updateEmployee.getEmpName());
        assertEquals(employeeDto.getCompanyName(), updateEmployee.getCompanyName());
    }

    public void testGetAllEmployee() {
        List<EmployeeDto> allEmployee = this.employeeService.getAllEmployee();
        Assert.assertFalse(allEmployee.isEmpty());
    }

    private EmployeeDto loadEmployeeToDatabase() {
        EmployeeDom employeeDom = getEmployeeDom();
        EmployeeDto employee = this.employeeService.createEmployee(getEmployeeDto(employeeDom));
        return employee;
    }

    private EmployeeDom getEmployeeDom() {
        EmployeeDom employeeDom = new EmployeeDom();
        employeeDom.setEmpName("Dummy");
        employeeDom.setAddress("City");
        employeeDom.setCompanyName("Company");
        employeeDom.setMobileNumber(35435345L);
        employeeDom.setEmailId("abc@gmail.com");
        return employeeDom;
    }

}
