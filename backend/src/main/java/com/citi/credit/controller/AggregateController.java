package com.citi.credit.controller;


import com.citi.credit.aggregates.*;
import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.service.AggregateService;
import com.citi.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AggregateController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private AggregateService aggregateService;

    @GetMapping(value="/transactions/gender")
    public ResponseEntity<List<genderAggregate>> transactionByGender() throws RecordNotFoundException {
        List<genderAggregate> transactions = aggregateService.transactionByGender();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/job")
    public ResponseEntity<List<jobAggregate>> transactionByJob() throws RecordNotFoundException {
        List<jobAggregate> transactions = aggregateService.transactionByJob();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/city")
    public ResponseEntity<List<cityAggregate>> transactionByCity() throws RecordNotFoundException {
        List<cityAggregate> transactions = aggregateService.transactionByCity();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/state")
    public ResponseEntity<List<stateAggregate>> transactionByState() throws RecordNotFoundException {
        List<stateAggregate> transactions = aggregateService.transactionByState();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/category")
    public ResponseEntity<List<categoryAggregate>> transactionByCategory() throws RecordNotFoundException {
        List<categoryAggregate> transactions = aggregateService.transactionByCategory();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/merchant")
    public ResponseEntity<List<merchantAggregate>> transactionByMerchant() throws RecordNotFoundException {
        List<merchantAggregate> transactions = aggregateService.transactionByMerchant();
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/spend/{threshold}")
    public ResponseEntity<List<Object>> getTransactionsBySpend(double customAmount) throws RecordNotFoundException {
        List<HighResults> highTransactions = aggregateService.transactionByHighValue(customAmount);
        List<LowResults> lowTransactions = aggregateService.transactionByLowValue(customAmount);
        List<Object> result = new ArrayList<>();
        result.add(0,highTransactions.get(0));
        result.add(1,lowTransactions.get(0));
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}
