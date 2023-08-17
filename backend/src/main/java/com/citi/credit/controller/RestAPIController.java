package com.citi.credit.controller;


import com.citi.credit.aggregates.*;
import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.service.AggregateService;
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

    @Autowired
    private AggregateService aggregateService;

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



    // POST method
<<<<<<< HEAD
    @PostMapping("/new_Customer")
    public ResponseEntity<Object> addCustomer(String _first, String _last, String _dob, String _gender,String _job) throws RecordNotFoundException{
=======
    @PostMapping("/newCustomer/{_first}/{_last}/{_dob}/{_gender}/{_job}")
    public ResponseEntity<Object> addCustomer(String _first, String _last, String _gender,String _job, String _dob) throws RecordNotFoundException{
>>>>>>> 5e5c7b121bde334d6c49d8e0beb70865afae647d
        try {
            customers _customer = this.creditService.addCustomer(_first,_last,_gender,_job,_dob);
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
