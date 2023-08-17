package com.citi.credit.aggregates;

import org.springframework.data.mongodb.core.mapping.Field;

public class jobAggregate {

    @Field("Job")
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private double totalAmount;


}
