package com.amsidh.mvc.controller;


import com.amsidh.mvc.SpringBootApp;
import com.amsidh.mvc.model.EmployeeDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = SpringBootApp.class,
        webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class EmployeeControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({"classpath:schema.sql", "classpath:data.sql"})
    @Test
    public void testGetAllEmployee() throws
            IllegalStateException, IOException {

        ResponseEntity<EmployeeDto[]> response =
                restTemplate.getForEntity("http://localhost:" + port + "/employees",
                        EmployeeDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(response.getBody().length > 0);
    }

    @Test
    public void testSearchEmployeeById() throws
            IllegalStateException, IOException {
        ResponseEntity<EmployeeDto> response =
                restTemplate.getForEntity("http://localhost:" + port + "/employees/1",
                        EmployeeDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateEmployee() {
        EmployeeDto employee = new EmployeeDto(10, "Name", "Company", 12345789L, "emailid@gmail.com", "City1");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/employees", employee, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
}
