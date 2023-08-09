package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.dataRepo.ICustomerData;
import com.citi.credit.dataRepo.ITransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService implements ICreditService{

    @Autowired
    private ICustomerData customerRepo;

    @Autowired
    private ITransactionData transactionRepo;

    @Override
    public List<customers> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public List<transactions> transactionByCustID(int _customerID) throws RecordNotFoundException {
        customers _customers  = customerRepo.findByCustomerID(_customerID);
        if(_customers==null){
            throw new RecordNotFoundException("Customer with customer ID"+_customerID+"doesnot exist");
        }
        return transactionRepo.findByCustomerID(_customerID);
    }

//    @Override
//    public List<transactions> transactionByName(String _first,String Last) throws RecordNotFoundException{
//        return null;
//    }
}
