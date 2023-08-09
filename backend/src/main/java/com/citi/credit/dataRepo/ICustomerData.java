package com.citi.credit.dataRepo;

import com.citi.credit.data.customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerData extends MongoRepository<customers,String> {



}
