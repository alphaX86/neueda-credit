package com.citi.credit.dataRepo;

import com.citi.credit.aggregates.*;
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
    public List<genderAggregate> transactionByGender() {
        GroupOperation groupByGenderAmount = group("gender").sum("amt").as("totalAmount");
        MatchOperation allGenders = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("gender").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGenders,groupByGenderAmount,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<genderAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", genderAggregate.class);
        List<genderAggregate> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<jobAggregate> transactionByJob() {
        GroupOperation grouper = group("Job").sum("amt").as("totalAmount");
        MatchOperation matcher = match(new Criteria("Job").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("Job").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(matcher,grouper,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<jobAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", jobAggregate.class);
        List<jobAggregate> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<stateAggregate> transactionByState() {
        GroupOperation groupByGenderAmount = group("state").sum("amt").as("totalAmount");
        MatchOperation allGenders = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("state").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGenders,groupByGenderAmount,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<stateAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", stateAggregate.class);
        List<stateAggregate> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<cityAggregate> transactionByCity() {
        GroupOperation groupByGenderAmount = group("city").sum("amt").as("totalAmount");
        MatchOperation allGenders = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("city").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGenders,groupByGenderAmount,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<cityAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", cityAggregate.class);
        List<cityAggregate> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<categoryAggregate> transactionByCategory() {
        GroupOperation groupByCategoryAmount = group("category").sum("amt").as("totalAmount");
        MatchOperation allCategory = match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("category").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allCategory,groupByCategoryAmount,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<categoryAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", categoryAggregate.class);
        List<categoryAggregate> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<merchantAggregate> transactionByMerchant() {
        GroupOperation groupByGenderAmount = group("merchant").sum("amt").as("totalAmount");
        MatchOperation allGenders = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("totalAmount").andExpression("merchant").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        Aggregation aggregation = newAggregation(allGenders,groupByGenderAmount,sortBySalesDesc,includes);
        org.springframework.data.mongodb.core.aggregation.AggregationResults<merchantAggregate> groupResults = mongoTemplate.aggregate(aggregation, "transactions", merchantAggregate.class);
        List<merchantAggregate> result = groupResults.getMappedResults();
        return result;
    }



}






