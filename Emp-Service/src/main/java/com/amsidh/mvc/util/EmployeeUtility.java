package com.amsidh.mvc.util;

import com.amsidh.mvc.entity.EmployeeDom;
import com.amsidh.mvc.model.EmployeeDto;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtility {

    private EmployeeUtility(){}
    public static EmployeeDom getEmployeeDom(EmployeeDto employeeDto) {
        return new ModelMapper().map(employeeDto, EmployeeDom.class);
    }

    public static EmployeeDto getEmployeeDto(EmployeeDom employeeDom) {
        return new ModelMapper().map(employeeDom, EmployeeDto.class);
    }

    public static List<EmployeeDom> getEmployeeDoms(List<EmployeeDto> employeeDtos) {
        List<EmployeeDom> listOfEmployeeDoms = new ArrayList<>();
        for (EmployeeDto employeeDto : employeeDtos) {
            listOfEmployeeDoms.add(getEmployeeDom(employeeDto));
        }
        return listOfEmployeeDoms;
    }

    public static List<EmployeeDto> getEmployeeDtos(List<EmployeeDom> employeeDoms) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (EmployeeDom employeeDom : employeeDoms) {
            employeeDtos.add(getEmployeeDto(employeeDom));
        }
        return employeeDtos;
    }
}
