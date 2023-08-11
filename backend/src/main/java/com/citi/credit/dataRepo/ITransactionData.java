package com.citi.credit.dataRepo;

import com.citi.credit.data.transactions;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ITransactionData extends MongoRepository<transactions,List<transactions>> {

    @Query("{customerID:?0}")
    List<transactions> findBycustomerID(int _customerID);

    List<transactions> findBygender(String _gender);

    List<transactions> findBycategory(String _category);

    List<transactions> findBymerchant(String _merchant);

    List<transactions> findBycity (String _city);

    List<transactions> findBystate (String _state);

    @Query("{city_population: {$gte: ?0, $lte: ?1}}")
    List<transactions> findByPopulation (int _populationFrom, int _populationTo);

    @Query("{amt:{ $gte: ?0, $lte: ?1}}")
    List<transactions> findBySpendingLimit (int _spendingLimitFrom, int _spendingLimitTo);
}
