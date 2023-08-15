package com.citi.credit.aggregates;

public class genderAggeregate {
    private String gender;
    private String job;
    private String state;
    private String merchant;
    private String category;
    private String city;

    private int highSpendingCust;
    private int lowSpendingCust;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHighSpendingCust() {
        return highSpendingCust;
    }

    public void setHighSpendingCust(int highSpendingCust) {
        this.highSpendingCust = highSpendingCust;
    }

    public int getLowSpendingCust() {
        return lowSpendingCust;
    }

    public void setLowSpendingCust(int lowSpendingCust) {
        this.lowSpendingCust = lowSpendingCust;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private double totalAmount;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
