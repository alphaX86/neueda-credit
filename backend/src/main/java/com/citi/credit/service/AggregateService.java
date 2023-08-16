package com.citi.credit.service;


import com.citi.credit.aggregates.*;
import com.citi.credit.dataRepo.CreditTemplate;
import com.citi.credit.dataRepo.ICustomerData;
import com.citi.credit.dataRepo.ITransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateService implements IAggregateService {

    //Repositories
    @Autowired
    private ICustomerData customerRepo;

    @Autowired
    private ITransactionData transactionRepo;

    @Autowired
    private CreditTemplate creditTemplate;


    @Override
    public List<genderAggregate> transactionByGender() {
        List<genderAggregate> documents = creditTemplate.transactionByGender();

        return documents;
    }

    @Override
    public List<jobAggregate> transactionByJob(){
        List<jobAggregate> documents = creditTemplate.transactionByJob();

        return documents;    }

    @Override
    public List<merchantAggregate> transactionByMerchant(){
        List<merchantAggregate> documents = creditTemplate.transactionByMerchant();

        return documents;    }

    @Override
    public List<cityAggregate> transactionByCity(){
        List<cityAggregate> documents = creditTemplate.transactionByCity();

        return documents;    }

    @Override
    public List<stateAggregate> transactionByState(){
        List<stateAggregate> documents = creditTemplate.transactionByState();

        return documents;    }

    @Override
    public List<categoryAggregate> transactionByCategory(){
        List<categoryAggregate> documents = creditTemplate.transactionByCategory();

        return documents;    }

    @Override
    public List<spendAggregate> transactionBySpentValue(double _low, double _high){
        List<spendAggregate> documents = creditTemplate.transactionBySpentValue(_low,_high);
        return documents;
    }
}
