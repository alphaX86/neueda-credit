package com.citi.credit.dataRepo;

import com.citi.credit.data.transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITransactionData extends MongoRepository<transactions,String> {



}
