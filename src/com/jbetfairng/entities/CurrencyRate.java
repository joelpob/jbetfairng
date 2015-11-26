package com.jbetfairng.entities;

public class CurrencyRate {
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public double getRate() {
        return rate;
    }

    private String currencyCode;
    private double rate;
}

