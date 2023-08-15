package com.citi.credit.service;

import com.citi.credit.aggregates.*;

import java.util.List;

public interface IAggregateService {
    public List<genderAggeregate> transactionByGender() ;

    public List<jobAggregate> transactionByJob() ;

    public List<cityAggregate> transactionByCity() ;

    public List<stateAggregate> transactionByState() ;

    public List<categoryAggregate> transactionByCategory() ;

    public List<merchantAggregate> transactionByMerchant() ;
}
