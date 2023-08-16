package com.citi.credit.dataRepo;

import com.citi.credit.aggregates.*;
import com.citi.credit.data.transactions;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CreditTemplate {

    List<genderAggregate> transactionByGender();

    List<jobAggregate> transactionByJob();

    List<cityAggregate> transactionByCity();

    List<stateAggregate> transactionByState();

    List<merchantAggregate> transactionByMerchant();

    List<categoryAggregate> transactionByCategory();

    List<spendAggregate> transactionBySpentValue(double _low, double _high);
}
