package com.citi.credit.dataRepo;


import com.citi.credit.aggregates.HighResults;
import com.citi.credit.aggregates.LowResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class HighLow implements IHighLow{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<HighResults> transactionByHighValue(double customAmount){
        GroupOperation grouper = group().sum("amt").as("totalAmount");
        MatchOperation matcher = match(new Criteria("amt").gte(customAmount));
        ProjectionOperation includes = project("totalAmount").andExpression("amt").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(matcher,grouper,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<HighResults> groupResults = mongoTemplate.aggregate(aggregation, "transactions", HighResults.class);
        List<HighResults> result = groupResults.getMappedResults();
        return result;

    }

    @Override
    public List<LowResults> transactionByLowValue(double customAmount){
        GroupOperation grouper = group().sum("amt").as("totalAmount");
        MatchOperation matcher = match(new Criteria("amt").lt(customAmount));
        ProjectionOperation includes = project("totalAmount").andExpression("amt").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(matcher,grouper,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<LowResults> groupResults = mongoTemplate.aggregate(aggregation, "transactions",LowResults.class);
        List<LowResults> result = groupResults.getMappedResults();
        return result;

    }


}
