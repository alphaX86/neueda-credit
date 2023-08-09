package com.citi.credit.dataRepo;

import com.citi.credit.data.transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ITransactionData extends MongoRepository<transactions,String> {

    @Query
    List<transactions> findByCustomerID(int _customerID);

}
