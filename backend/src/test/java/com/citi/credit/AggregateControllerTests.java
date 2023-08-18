package com.citi.credit;

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

import com.citi.credit.data.transactions;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AggregateControllerTests {
    @Autowired
    public TestRestTemplate restTemplate;

    // API reachablity tests
    @Test
    public void reachGetAllTransactionsByCity() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/city", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByState() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/state", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByCategory() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/category", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    
    @Test
    public void reachGetAllTransactionsByProfession() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/job", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsBySpendLimit() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/spend/1200", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void reachGetAllTransactionsByGender() {
        ResponseEntity<List<transactions>> result = restTemplate.exchange("/api/transactions/gender", HttpMethod.GET, null, new ParameterizedTypeReference<List<transactions>>() {});
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
