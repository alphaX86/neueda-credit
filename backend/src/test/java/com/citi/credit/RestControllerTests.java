package com.citi.credit;

import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTests {
    @Autowired
    public TestRestTemplate restTemplate;

    // API reachablity tests
    @Test
    public void reachGetCustomer() {
        ResponseEntity<List<customers>> result = restTemplate.exchange("/api/customer?_customerID=1", HttpMethod.GET, null, new ParameterizedTypeReference<List<customers>>() {});
        assertEquals(HttpStatus.TEMPORARY_REDIRECT, result.getStatusCode());
    }

    @Test
    public void reachGetTransaction() {
        ResponseEntity<List<customers>> result = restTemplate.exchange("/api/customer/transaction?_customerID=1", HttpMethod.GET, null, new ParameterizedTypeReference<List<customers>>() {});
        assertEquals(HttpStatus.TEMPORARY_REDIRECT, result.getStatusCode());
    }

    @Test
    public void reachGetAllCustomers() {
        ResponseEntity<List<customers>> result = restTemplate.exchange("/api/allCustomers", HttpMethod.GET, null, new ParameterizedTypeReference<List<customers>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactions() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
