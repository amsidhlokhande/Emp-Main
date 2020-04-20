package com.amsidh.mvc.repository;

import com.amsidh.mvc.entity.EmployeeDom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories(basePackages = {"com.amsidh.mvc.repository"})
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDom, Integer> {
}