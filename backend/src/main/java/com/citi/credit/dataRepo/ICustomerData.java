package com.citi.credit.dataRepo;

import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ICustomerData extends MongoRepository<customers,String> {

    @Query
    customers findBycustomerID(int _customerID);

}
