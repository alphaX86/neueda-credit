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

    @GetMapping(value="/customer/transaction/{_customerID}")
    public ResponseEntity<Object> transactionByCustID(@PathVariable String _customerID) throws RecordNotFoundException {
        try {
            List<transactions> list = this.creditService.transactionByCustID(Integer.parseInt(_customerID));
            return ResponseEntity.status(HttpStatus.FOUND).body(list);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value="/customer/{_customerID}")
    public ResponseEntity<Object> getCustomerByID(@PathVariable String _customerID) throws RecordNotFoundException {
        try {customers customer = this.creditService.getCustomerByID(Integer.parseInt(_customerID));
            return ResponseEntity.status(HttpStatus.FOUND).body(customer);
        } catch (RecordNotFoundException e) {
            // throw new RuntimeException(e);
            return ResponseEntity.noContent().build();
        }
    }



    // POST method
    @PostMapping("/newCustomer/{_first}/{_last}/{_dob}/{_gender}/{_job}")
    public ResponseEntity<Object> addCustomer(@PathVariable String _first, @PathVariable String _last, @PathVariable String _gender, @PathVariable String _job, @PathVariable String _dob) throws RecordNotFoundException{
        try {
            customers _customer = this.creditService.addCustomer(_first,_last,_gender,_job,_dob);
            return ResponseEntity.status(HttpStatus.CREATED).body("customr added succesfully");
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PostMapping("/transactions/{custId}/{amt}/{category}/{merchant}/{city}/{state}")
    public ResponseEntity<Object> addTransaction(@PathVariable int custId,@PathVariable double amt,@PathVariable String category,@PathVariable String merchant,@PathVariable String city,@PathVariable String state) throws RecordNotFoundException{
        try {
            transactions transactions = this.creditService.addTransaction(custId,amt,category,merchant,city,state);
            return ResponseEntity.status(HttpStatus.CREATED).body(transactions);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{_customerID}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int _customerID) throws RecordNotFoundException{
        try{
            customers _customer = this.creditService.deleteCustomer(_customerID);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(_customer);
        }catch (RecordNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
}
