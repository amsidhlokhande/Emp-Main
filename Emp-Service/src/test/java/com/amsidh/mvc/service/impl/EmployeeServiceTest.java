package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.EmployeeDom;
import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.repository.EmployeeRepository;
import com.amsidh.mvc.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.amsidh.mvc.util.EmployeeUtility.getEmployeeDto;
import static java.util.Collections.singletonList;
import static java.util.Optional.of;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Before
    public void setup(){
     this.employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void testCreateEmployee(){
        EmployeeDom employeeDom = getEmployeeDom();
        when(this.employeeRepository.save(any(EmployeeDom.class))).thenReturn(employeeDom);

        EmployeeDto employee = this.employeeService.createEmployee(getEmployeeDto(employeeDom));
        assertNotNull(employee.getEmpId());
    }

    @Test
    public void testSearchEmployeeById(){

        when(this.employeeRepository.findById(any(Integer.class))).thenReturn(of(getEmployeeDom()));
        EmployeeDto employee = this.employeeService.searchEmployeeById(123);
        assertNotNull(employee);
    }

    @Test
    public void testRemoveEmployeeById(){

        doNothing().when(employeeRepository).deleteById(any(Integer.class));
       this.employeeService.removeEmployee(123);
        verify(employeeRepository, atLeastOnce()).deleteById(any(Integer.class));
    }

    @Test
    public void testUpdateEmployee(){

        when(this.employeeRepository.findById(any(Integer.class))).thenReturn(of(getEmployeeDom()));
        doNothing().when(employeeRepository).flush();
        EmployeeDto employeeDto = this.employeeService.updateEmployee(123, getEmployeeDto(getEmployeeDom()));

        assertNotNull(employeeDto);
        verify(employeeRepository, atLeastOnce()).findById(any(Integer.class));
        verify(employeeRepository, atLeastOnce()).flush();
    }

    @Test
    public void testGetAllEmployee(){

        when(this.employeeRepository.findAll()).thenReturn(singletonList(getEmployeeDom()));
        List<EmployeeDto> allEmployee = this.employeeService.getAllEmployee();

        Assert.assertFalse(allEmployee.isEmpty());
        verify(employeeRepository, atLeastOnce()).findAll();
    }

    private EmployeeDom getEmployeeDom() {
        EmployeeDom employeeDom = new EmployeeDom();
        employeeDom.setEmpId(123);
        employeeDom.setEmpName("Dummy");
        employeeDom.setAddress("Pune");
        employeeDom.setCompanyName("Deutsche Bank");
        employeeDom.setMobileNumber(8108551845L);
        employeeDom.setEmailId("amsidhlokhande");
        return employeeDom;
    }


}
