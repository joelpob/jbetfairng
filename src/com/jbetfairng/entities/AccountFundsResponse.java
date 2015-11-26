package com.jbetfairng.entities;

public class AccountFundsResponse {
    public void setAvailableToBetBalance(double availableToBetBalance) {
        this.availableToBetBalance = availableToBetBalance;
    }
    
    public double getAvailableToBetBalance() {
        return availableToBetBalance;
    }

    public void setExposure(double exposure) {
        this.exposure = exposure;
    }
    
    public double getExposure() {
        return exposure;
    }

    public void setRetainedCommission(double retainedCommission) {
        this.retainedCommission = retainedCommission;
    }
    
    public double getRetainedCommission() {
        return retainedCommission;
    }

    public void setExposureLimit(double exposureLimit) {
        this.exposureLimit = exposureLimit;
    }
    
    public double getExposureLimit() {
        return exposureLimit;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double getDiscountRate() {
        return discountRate;
    }

    public void setPointsBalance(double pointsBalance) {
        this.pointsBalance = pointsBalance;
    }
    
    public double getPointsBalance() {
        return pointsBalance;
    }

    private double availableToBetBalance;
    private double exposure;
    private double retainedCommission;
    private double exposureLimit;
    private double discountRate;
    private double pointsBalance;
}
