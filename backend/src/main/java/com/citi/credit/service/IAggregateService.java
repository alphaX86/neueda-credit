package com.citi.credit.service;

import com.citi.credit.aggregates.*;

import java.util.List;

public interface IAggregateService {
    public List<genderAggregate> transactionByGender() ;

    public List<jobAggregate> transactionByJob() ;

    public List<cityAggregate> transactionByCity() ;

    public List<stateAggregate> transactionByState() ;

    public List<categoryAggregate> transactionByCategory() ;

    public List<merchantAggregate> transactionByMerchant() ;

    List<HighResults> transactionByHighValue(double customAmount);

    public List<LowResults> transactionByLowValue(double customAmount) ;

}
