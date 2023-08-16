package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.dataRepo.CreditTemplate;
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

    @Autowired
    private CreditTemplate creditTemplate;

    @Override
    public List<customers> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public List<transactions> getAllTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public customers getCustomerByID(int _customerID) throws RecordNotFoundException{
        customers customer = customerRepo.findBycustomerID(_customerID);
        if (customer == null){
            throw new RecordNotFoundException("Customer with customer ID"+_customerID+"doesnot exist");
        }
        return customer;
    }

    @Override
    public List<transactions> transactionByCustID(int _customerID) throws RecordNotFoundException {
        customers _customers  = customerRepo.findBycustomerID(_customerID);
        if(_customers==null){
            throw new RecordNotFoundException("Customer with customer ID"+_customerID+"doesnot exist");
        }
        return transactionRepo.findBycustomerID(_customerID);
    }




    public customers addCustomer(String _first, String _last, String _dob, String _gender,String _job) throws RecordNotFoundException {
        customers _newCustomer = new customers(_first,_last,_dob,_job,_gender,-1);
        int custID = _newCustomer.getCustomer_id();

        int count = (int)this.customerRepo.count();
        _newCustomer.setCustomer_id(count+1);
        customers newCustomer = customerRepo.save(_newCustomer);
        System.out.printf("There are now %d employees\n", customerRepo.count());
        return  newCustomer;
    }

    //deletion
    @Override
    public customers deleteCustomer(int _customerID) throws RecordNotFoundException {
        customers _customer = customerRepo.findBycustomerID(_customerID);
        if (_customer == null){
            throw new RecordNotFoundException("customer record with " + _customerID + "doesnot exists");
        }

        customerRepo.delete(_customer);
        return _customer;
    }

}
