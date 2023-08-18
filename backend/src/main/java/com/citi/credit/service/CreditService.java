package com.citi.credit.service;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.dataRepo.CreditTemplate;
import com.citi.credit.dataRepo.ICustomerData;
import com.citi.credit.dataRepo.ITransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
            throw new RecordNotFoundException("Customer with customer ID"
                    +_customerID+"does not exist");
        }
        return customer;
    }

    @Override
    public List<transactions> transactionByCustID(int _customerID) throws RecordNotFoundException {
        customers _customers  = customerRepo.findBycustomerID(_customerID);
        if(_customers==null){
            throw new RecordNotFoundException("Customer with customer ID"
                    +_customerID+"does not exist");
        }
        return transactionRepo.findBycustomerID(_customerID);
    }




    @Override
    public customers addCustomer(String _first, String _last,  String _gender,String _job,String _dob) throws RecordNotFoundException {
        customers _newCustomer = new customers(_first,_last,_gender,_job,_dob,-1);
        int custID = _newCustomer.getCustomer_id();

        int count = (int)this.customerRepo.count();
        _newCustomer.setCustomer_id(count+1);
        customers newCustomer = customerRepo.save(_newCustomer);
        System.out.printf("There are now %d employees\n", customerRepo.count());
        return  newCustomer;
    }

    @Override
    public transactions addTransaction(int custId,double amt, String category,String merchant, String city, String state) throws RecordNotFoundException{
        customers customer = customerRepo.findBycustomerID(custId);
        if (customer == null){
             throw new RecordNotFoundException("Customer with customer ID"
                    +custId+"does not exist");
        }
        Random rand = new Random();
        String _job = customer.getJob();
        String _gender = customer.getGender();
        String _dob = customer.getDob();
        String _first = customer.getFirst();
        String _last = customer.getLast();
        String dateTime = LocalDateTime.now().toString();
        int transNum = rand.nextInt(1665000,9999999);

        transactions newTrans = new transactions(dateTime,amt,transNum,custId,city,state,merchant,category,_first,_last,_gender,_job,_dob);
        transactionRepo.save(newTrans);
        return newTrans;
    }


    //deletion
    @Override
    public customers deleteCustomer(int _customerID) throws RecordNotFoundException {
        customers _customer = customerRepo.findBycustomerID(_customerID);
        if (_customer == null){
            throw new RecordNotFoundException("customer record with "
                    + _customerID + "does not exists");
        }

        customerRepo.delete(_customer);
        return _customer;
    }

}
