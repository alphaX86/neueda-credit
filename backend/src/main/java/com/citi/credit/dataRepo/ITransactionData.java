package com.citi.credit.dataRepo;

import com.citi.credit.data.transactions;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ITransactionData extends MongoRepository<transactions,String> {

    @Query("{customerID:?0}")
    List<transactions> findBycustomerID(int _customerID);

    @Query
    List<transactions> findBygender(String _gender);

    @Query
    List<transactions> findBycategory(String _category);

    @Query
    List<transactions> findBymerchant(String _merchant);

    @Query
    List<transactions> findBycity (String _city);

    @Query
    List<transactions> findBystate (String _state);

    @Query("{amt:{ $gte: ?0, $lte: ?1}}")
    List<transactions> findBySpendingLimit (int _spendingLimitFrom, int _spendingLimitTo);

    @Query
    List<transactions> findByJob (String _job);
}
