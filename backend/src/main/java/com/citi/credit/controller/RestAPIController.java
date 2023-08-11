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

    @GetMapping("/Customers/all")
    public List<customers> getAllCustomers(){

        return creditService.getAllCustomers();

    }

    @GetMapping("/analysis/gender")
    public List<Double> transactionBygender(String _gender){

        List<Double> genderTransactions = this.creditService.transactionBygender(_gender);
        return genderTransactions;

    }

    @GetMapping("/Customer/Transaction")
    public ResponseEntity<Object> transactionByCustID(int _customerID) throws RecordNotFoundException {
        try {
            List<transactions> list = this.creditService.transactionByCustID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(list);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/Customer")
    public ResponseEntity<Object> getCustomerByID(int _customerID) throws RecordNotFoundException {
        try {customers customer = this.creditService.getCustomerByID(_customerID);
            return ResponseEntity.status(HttpStatus.FOUND).body(customer);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }


    //post method
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
