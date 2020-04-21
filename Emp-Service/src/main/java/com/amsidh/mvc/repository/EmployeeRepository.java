package com.amsidh.mvc.repository;

import com.amsidh.mvc.entity.EmployeeDom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDom, Integer> {
}
