package com.citi.credit.data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class transactions {

    @Id
    private ObjectId _id;
    private String trans_date_trans_time;
    private double amt;
    private int trans_num;
    @Field("customer_id")
    private int customerID;
    private String city;
    private String state;
    private int city_population;
    private String merchant;
    private String category;
    private String first;
    private String last;
    private String gender;
    private String job;
    private String dob;

    //Getters and Setters

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTrans_date_trans_time() {
        return trans_date_trans_time;
    }

    public void setTrans_date_trans_time(String trans_date_trans_time) {
        this.trans_date_trans_time = trans_date_trans_time;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public int getTrans_num() {
        return trans_num;
    }

    public void setTrans_num(int trans_num) {
        this.trans_num = trans_num;
    }

    public int getCustomer_id() {
        return customerID;
    }

    public void setCustomer_id(int customer_id) {
        this.customerID = customer_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCity_population() {
        return city_population;
    }

    public void setCity_population(int city_population) {
        this.city_population = city_population;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    //Constructors


    public transactions() {
    }

    public transactions(int customer_id) {
        this.customerID = customer_id;
    }

    public transactions(int trans_num, int customer_id, String first, String last, String dob) {
        this.trans_num = trans_num;
        this.customerID = customer_id;
        this.first = first;
        this.last = last;
        this.dob = dob;
    }

    public transactions(ObjectId _id, String trans_date_trans_time, double amt, int trans_num, int customer_id, String city, String state, int city_population, String merchant, String category, String first, String last, String gender, String job, String dob) {
        this._id = _id;
        this.trans_date_trans_time = trans_date_trans_time;
        this.amt = amt;
        this.trans_num = trans_num;
        this.customerID = customer_id;
        this.city = city;
        this.state = state;
        this.city_population = city_population;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
    }

    //toString method

    @Override
    public String toString() {
        return "transactions{" +
                "_id=" + _id +
                ", trans_date_trans_time='" + trans_date_trans_time + '\'' +
                ", amt=" + amt +
                ", trans_num=" + trans_num +
                ", customer_id=" + customerID +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", city_population=" + city_population +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
