package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getById() {
        EmployeeResponse result = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Nekko1", result.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
    })
    public void getByIdList(int id) {
        EmployeeResponse result = restTemplate.getForObject("/employee/"+id, EmployeeResponse.class);
        assertEquals(id, result.getId());
        assertEquals("Nekko"+id, result.getName());
    }
}