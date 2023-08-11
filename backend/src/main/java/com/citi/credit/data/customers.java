package com.citi.credit.data;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class customers {

    @Id
    private ObjectId _id;
    private String first;
    private String last;
    private String gender;
    private String job;
    private String dob;
    @Field("customer_id")
    private int customerID;



    //Getters and Setters


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getCustomer_id() {
        return customerID;
    }

    public void setCustomer_id(int customer_id) {
        this.customerID = customer_id;
    }

    //Constructors

    public customers(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public customers() {
    }

    public customers(String first, String last, String dob) {
        this.first = first;
        this.last = last;
        this.dob = dob;
    }

    public customers(int customer_id) {
        this.customerID = customer_id;
    }

    public customers(String first, String last, String gender, String job, String dob,int customerID) {
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
        this.customerID = customerID;
    }

    public customers(ObjectId _id, String first, String last, String gender, String job, String dob, int customer_id) {
        this._id = _id;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
        this.customerID = customer_id;
    }

    //toString method

    @Override
    public String toString() {
        return "customers{" +
                "_id='" + _id + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob='" + dob + '\'' +
                ", customer_id=" + customerID+
                '}';
    }
}

