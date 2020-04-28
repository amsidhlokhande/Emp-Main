package com.amsidh.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeDto {
    private Integer empId;
    private String empName;
    private String companyName;
    private Long mobileNumber;
    private String emailId;
    private String address;
}
