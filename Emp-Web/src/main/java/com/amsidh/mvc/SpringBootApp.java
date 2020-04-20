package com.amsidh.mvc;

import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class SpringBootApp implements CommandLineRunner {
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     /*   EmployeeDto employeeDto = new EmployeeDto();
        //employeeDto.setEmpId(1);
        employeeDto.setEmpName("Amsidh Lokhande");
        employeeDto.setCompanyName("Deutsche Bank");
        //employeeDto.setJoiningDate(new Date());
        employeeDto.setMobileNumber(8108551845L);
        employeeDto.setEmailId("amsidhlokhande@gmail.com");
        employeeDto.setAddress("Pune");
        EmployeeDto employee = this.employeeService.createEmployee(employeeDto);
        log.info(employee.toString());*/
    }
}
