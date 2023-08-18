package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;

import java.util.List;


public interface ICreditService {

    // CREATE
    public customers addCustomer(String _first, String _last, String _dob, String _gender,String job) throws RecordNotFoundException;

    // UPDATE
    // TBD

    // RETRIEVE
    public List<customers> getAllCustomers();

    public List<transactions> getAllTransactions();

    public customers getCustomerByID(int _customerID) throws RecordNotFoundException;

    public List<transactions> transactionByCustID(int _customerID) throws RecordNotFoundException;

    //public List<transactions> transactionByName(String _first,String _last) throws RecordNotFoundException;


    public transactions addTransaction(int custId,double amt, String category,String merchant, String city, String state) throws RecordNotFoundException;

    // DELETE
    public customers deleteCustomer(int _customerID) throws RecordNotFoundException;
}
