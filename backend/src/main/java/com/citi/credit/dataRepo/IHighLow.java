package com.citi.credit.dataRepo;

import com.citi.credit.aggregates.HighResults;
import com.citi.credit.aggregates.LowResults;

import java.util.List;

public interface IHighLow {

    List<HighResults> transactionByHighValue(double customAmount);

    List<LowResults> transactionByLowValue(double customAmount);

}

