package com.amsidh.mvc.controller;

import com.amsidh.mvc.SpringBootApp;
import com.amsidh.mvc.model.EmployeeDto;
import com.amsidh.mvc.service.impl.EmployeeServiceImpl;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {EmployeeController.class})
@ContextConfiguration(classes = {SpringBootApp.class})
public class EmployeeControllerTest {
    public static final String BASE_ADDRESS_URL = "/employees";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeServiceImpl;


    @Test
    public void testGetEmployees() throws Exception {

        RequestBuilder requestBuilder = get(BASE_ADDRESS_URL).contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON);

        List<EmployeeDto> employeeDtos = getEmployeeDtos();

        when(employeeServiceImpl.getAllEmployee()).thenReturn(employeeDtos);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertTrue(result.getResponse().getStatus() == 200);
        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetEmployeesWithEmptyResult() throws Exception {

        RequestBuilder requestBuilder = get(BASE_ADDRESS_URL).contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON);

        when(employeeServiceImpl.getAllEmployee()).thenReturn(Arrays.asList());

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertTrue(result.getResponse().getStatus() == 200);
        assertTrue(result.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    public void testSaveEmployee() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto(1, "Name", "Company", 12345789L, "emailid@gmail.com", "City1");
        JSONObject employeeJson = new JSONObject();
        employeeJson.put("employee", employeeDto);
        RequestBuilder requestBuilder = post(BASE_ADDRESS_URL)
                .contentType(APPLICATION_JSON).content(employeeJson.toString())
                .accept(APPLICATION_JSON);

        when(employeeServiceImpl.createEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertTrue(result.getResponse().getStatus() == 200);
        assertNotNull(result.getResponse().getContentAsString());

    }


    private List<EmployeeDto> getEmployeeDtos() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employeeDtos.add(new EmployeeDto(1,"Name","Company",12345789L,"emailid@gmail.com","City1"));
        employeeDtos.add(new EmployeeDto(2,"Name","Company",12345789L,"emailid@gmail.com","City2"));
        employeeDtos.add(new EmployeeDto(3,"Name","Company",12345789L,"emailid@gmail.com","City3"));
        return employeeDtos;
    }
}
