package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import org.springframework.stereotype.Service;

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
    public List<Double> transactionBygender(String _gender) ;

    public List<transactions> getAllTransactionsByGender(String gender) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsByCategory(String _category) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsByMerchant(String _merchant) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsByState(String _state) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsByCity(String _city) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsBySpending(int _spendingLimitFrom, int _spendingLimitTo) throws RecordNotFoundException;

    public List<transactions> getAllTransactionsByJob(String _profession) throws RecordNotFoundException;

    // DELETE
    public customers deleteCustomer(int _customerID) throws RecordNotFoundException;
}
