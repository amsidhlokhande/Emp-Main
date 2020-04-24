package com.amsidh.mvc;

import com.amsidh.mvc.repository.EmployeeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {EmployeeRepository.class})
@SpringBootApplication
public class EmployeeServiceApp {
}
