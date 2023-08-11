package com.citi.credit.controller;


import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestAPIController {

    @Autowired
    private CreditService creditService;

    @GetMapping(value="/allCustomers")
    public List<customers> getAllCustomers(){

        return creditService.getAllCustomers();

    }
    @GetMapping(value="/transactions")
    public List<transactions> getAllTransactions(){
        return creditService.getAllTransactions();
    }

    @GetMapping(value="/customer/transaction")
    public ResponseEntity<Object> transactionByCustID(int _customerID) throws RecordNotFoundException {
        try {
            List<transactions> list = this.creditService.transactionByCustID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(list);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value="/customer")
    public ResponseEntity<Object> getCustomerByID(int _customerID) throws RecordNotFoundException {
        try {customers customer = this.creditService.getCustomerByID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(customer);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value="/transactions/gender/{gender}")
    public ResponseEntity<List<transactions>> getTransactionsByGender(@PathVariable String gender) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByGender(gender);
        if (transactions.size()==0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/city/{city}")
    public ResponseEntity<List<transactions>> getTransactionsByCity(@PathVariable String city) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByCity(city);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/category/{category}")
    public ResponseEntity<List<transactions>> getTransactionsByCategory(@PathVariable String category) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByCategory(category);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/state/{state}")
    public ResponseEntity<List<transactions>> getTransactionsByState(@PathVariable String state) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByCity(state);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/merchant/{merchant}")
    public ResponseEntity<List<transactions>> getTransactionsByMerchant(@PathVariable String merchant) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByMerchant(merchant);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/spend/{from}/{to}")
    public ResponseEntity<List<transactions>> getTransactionsBySpend(@PathVariable("from") int _spendingLimitFrom, @PathVariable("to") int _spendingLimitTo) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsBySpending(_spendingLimitFrom,_spendingLimitTo);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @GetMapping(value="/transactions/profession/{job}")
    public ResponseEntity<List<transactions>> getTransactionsByJob(@PathVariable String job) throws RecordNotFoundException {
        List<transactions> transactions = creditService.getAllTransactionsByJob(job);
        if (transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);

    // POST method
    @PostMapping("/new_Customer")
    public ResponseEntity<Object> addCusotomer(String _first, String _last, String _dob, String _gender,String _job) throws RecordNotFoundException{
        try {
            customers _customer = this.creditService.addCustomer(_first,_last,_dob,_job,_gender);
            return ResponseEntity.status(HttpStatus.CREATED).body(_customer);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCustomer(int _customerID) throws RecordNotFoundException{
        try{
            customers _customer = this.creditService.deleteCustomer(_customerID);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(_customer);
        }catch (RecordNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
}
