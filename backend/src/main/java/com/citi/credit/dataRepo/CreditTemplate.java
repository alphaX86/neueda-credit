package com.citi.credit.dataRepo;

import com.citi.credit.aggregates.*;

import java.util.List;

public interface CreditTemplate {

    List<genderAggregate> transactionByGender();

    List<jobAggregate> transactionByJob();

    List<cityAggregate> transactionByCity();

    List<stateAggregate> transactionByState();

    List<merchantAggregate> transactionByMerchant();

    List<categoryAggregate> transactionByCategory();


}
