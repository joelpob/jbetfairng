package com.jbetfairng.entities;

public class AccountDetailsResponse { 
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }
    
    public String getLocaleCode() {
        return localeCode;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getRegion() {
        return region;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    
    public String getTimeZone() {
        return timeZone;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double getDiscountRate() {
        return discountRate;
    }

    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }
    
    public int getPointsBalance() {
        return pointsBalance;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public String getCountryCode() {
        return countryCode;
    }

    private String currencyCode;
    private String firstName;
    private String lastName;
    private String localeCode;
    private String region;
    private String timeZone;
    private double discountRate;
    private int pointsBalance;
    private String countryCode;
}
