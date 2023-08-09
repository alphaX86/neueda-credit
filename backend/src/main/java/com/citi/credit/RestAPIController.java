package com.citi.credit;


import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
