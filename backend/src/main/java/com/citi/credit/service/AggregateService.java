package com.citi.credit.service;


import com.citi.credit.aggregates.*;
import com.citi.credit.dataRepo.*;
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

    @Autowired
    private IHighLow highLow;


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
    public List<HighResults> transactionByHighValue(double customAmount){
        List<HighResults> documents = highLow.transactionByHighValue(customAmount);
        return documents;
    }

    @Override
    public List<LowResults> transactionByLowValue(double customAmount){
        List<LowResults> documents = highLow.transactionByLowValue(customAmount);
        return documents;
    }


}
