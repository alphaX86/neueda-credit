package com.citi.credit.controller;


import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestAPIController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/allCustomers")
    public List<customers> getAllCustomers(){

        return creditService.getAllCustomers();

    }
    @GetMapping("/transactions")
    public List<transactions> getAllTransactions(){
        return creditService.getAllTransactions();
    }

    @GetMapping("/customer/transaction")
    public ResponseEntity<Object> transactionByCustID(int _customerID) throws RecordNotFoundException {
        try {
            List<transactions> list = this.creditService.transactionByCustID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(list);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomerByID(int _customerID) throws RecordNotFoundException {
        try {customers customer = this.creditService.getCustomerByID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(customer);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/transactions/gender/{gender}")
    public ResponseEntity<List<transactions>> getTransactionsByGender(@PathVariable String gender) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByGender(gender);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping("/transactions/city/{city}")
    public ResponseEntity<List<transactions>> getTransactionsByCity(@PathVariable String city) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByCity(city);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }
}
