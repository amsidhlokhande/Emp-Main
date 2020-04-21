package com.amsidh.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class SpringBootApp implements CommandLineRunner {

   /* @Value("${spring.datasource.url}")
    private String h2databaseUrl;

    @Value("${server.servlet.application-display-name}")
    private String applicationName;
*/
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{EmployeeServiceApp.class, SpringBootApp.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Database url = " + h2databaseUrl);
        System.out.println("Application name = " + applicationName);*/
    }
}
