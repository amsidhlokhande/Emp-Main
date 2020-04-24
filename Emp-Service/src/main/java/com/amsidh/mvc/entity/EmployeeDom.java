package com.amsidh.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@SelectBeforeUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeDom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPID")
    private Integer empId;
    @Column(name = "EMPNAME")
    private String empName;
    @Column(name = "COMPANY")
    private String companyName;
    @Column(name = "CONTACT_NUMBER")
    private Long mobileNumber;
    @Column(name = "EMAILID")
    private String emailId;
    @Column(name = "ADDRESS")
    private String address;
}
