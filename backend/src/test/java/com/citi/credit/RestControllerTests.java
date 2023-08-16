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
    public void reachGetAllCustomers() {
        ResponseEntity<List<customers>> result = restTemplate.exchange("/api/allCustomers", HttpMethod.GET, null, new ParameterizedTypeReference<List<customers>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactions() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByGender() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/gender/M", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByMerchant() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/merchant/Baumbach%20Ltd", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByCity() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/city/Achille", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByState() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/state/OK", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByCategory() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/category/gas_transport", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    
    @Test
    public void reachGetAllTransactionsByProfession() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/profession/Seismic%20interpreter", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsBySpendLimit() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/spend/1000/1500", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    // Conditional tests
    // TBD 
}
