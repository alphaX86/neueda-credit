package com.citi.credit.dataRepo;

import com.citi.credit.data.AnalysisResults;
import com.citi.credit.data.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class CreditImplement implements CreditTemplate{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<AnalysisResults> transactionByGender() {
        GroupOperation groupByGenderAmount = group("gender").sum("amt").as("totalAmount");
        MatchOperation allGenders = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("gender").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGenders,groupByGenderAmount,sortBySalesDesc,includes);
        AggregationResults<AnalysisResults> groupResults = mongoTemplate.aggregate(aggregation, "transactions", AnalysisResults.class);
        List<AnalysisResults> result = groupResults.getMappedResults();
        return result;
    }
}
