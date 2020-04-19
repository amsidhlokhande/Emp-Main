package com.amsidh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.doms.EmployeeDom;
import com.amsidh.dtos.EmployeeDto;
import com.amsidh.util.DomDaoCreatorUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String createEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(DomDaoCreatorUtil.getEmployeeDom(employee));
			return "Employee Added Successfully";
		} catch (Exception ex) {
			return ex.getMessage();
		} finally {
			session.flush();
			session.getTransaction().commit();
			session.close();
		}

	}

	public String removeEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(session.get(EmployeeDom.class,employee.getEmpId() ));
			return "Employee with employeeID " + employee.getEmpId()
					+ " is deleted successfully";
		} catch (HibernateException hex) {
			return "No Record found :" + hex.getLocalizedMessage();

		} finally {
			session.flush();
			session.getTransaction().commit();
			session.close();
		}

	}

	public EmployeeDto updateEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(DomDaoCreatorUtil.getEmployeeDom(employee));
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employee;
	}

	public EmployeeDto searchEmployee(EmployeeDto employee) {
		EmployeeDto employeeDto = null;
		List<EmployeeDto> listOfemployeDto = new ArrayList<EmployeeDto>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from EmployeeDom where empId="
				+ employee.getEmpId());
		listOfemployeDto = DomDaoCreatorUtil
				.getEmployeeDtos((List<EmployeeDom>) query.list());
		if (!listOfemployeDto.isEmpty()) {
			employeeDto = listOfemployeDto.get(0);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employeeDto;

	}

	public List<EmployeeDto> getAllEmployee() {

		List<EmployeeDto> listOfemployeDto = new ArrayList<EmployeeDto>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		listOfemployeDto = DomDaoCreatorUtil
				.getEmployeeDtos((List<EmployeeDom>) session.createQuery(
						"from EmployeeDom").list());
		session.flush();
		session.getTransaction().commit();
		session.close();
		return listOfemployeDto;
	}

}
