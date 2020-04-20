package com.amsidh.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeDto {
    private Integer empId;
    private String empName;
    private String companyName;
    private Date joiningDate;
    private Long mobileNumber;
    private String emailId;
    private String address;
}
