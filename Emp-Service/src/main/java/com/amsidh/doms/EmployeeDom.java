package com.amsidh.doms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity()
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name = "EMPLOYEE")

public class EmployeeDom {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "EMPID", length = 10, nullable = false)
	private Integer empId;
	@Column(name = "EMPNAME", nullable = false)
	private String empName;
	@Column(name = "COMPANY")
	private String companyName;
	@Column(name = "JOINING_DATE")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	@Column(name = "CONTACT_NUMBER")
	private Long mobileNumber;
	@Column(name = "EMAILID")
	private String emailId;
	@Column(name = "ADDRESS", length = 250)
	private String address;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
