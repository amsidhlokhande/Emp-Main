package com.amsidh.mvc.controller;


import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/employees")
@Data
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    @GetMapping(produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @GetMapping(value = "/{employeeId}", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("employeeId") Integer employeeId) {

        EmployeeDto searchedEmployee = employeeService.searchEmployeeById(employeeId);
        return ResponseEntity.ok().body(searchedEmployee);
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{employeeId}", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.removeEmployee(employeeId);
        return ResponseEntity.ok().body("Employee Deleted successfully");
    }

}
