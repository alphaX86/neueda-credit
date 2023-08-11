package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICreditService {

    public List<customers> getAllCustomers();

    public customers getCustomerByID(int _customerID) throws RecordNotFoundException;

    public List<transactions> transactionByCustID(int _customerID) throws RecordNotFoundException;

    //public List<transactions> transactionByName(String _first,String _last) throws RecordNotFoundException;
    public List<Double> transactionBygender(String _gender) ;


    public customers addCustomer(String _first, String _last, String _dob, String _gender,String job) throws RecordNotFoundException;


    //delete
    public customers deleteCustomer(int _customerID) throws RecordNotFoundException;

}
