package com.amsidh.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
    @Column(name = "EMPID", length = 10, nullable = false)
    private Integer empId;
    @Column(name = "EMPNAME", nullable = false)
    private String empName;
    @Column(name = "COMPANY")
    private String companyName;
    @Column(name = "JOINING_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  //Non modifiable date
    //@UpdateTimestamp  //Modifiable Date
    private Date joiningDate;
    @Column(name = "CONTACT_NUMBER")
    private Long mobileNumber;
    @Column(name = "EMAILID")
    private String emailId;
    @Column(name = "ADDRESS", length = 250)
    private String address;
}
