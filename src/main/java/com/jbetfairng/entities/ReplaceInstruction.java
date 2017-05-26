package com.jbetfairng.entities;

public class ReplaceInstruction {
    public void setBetId(String betId) {
        this.betId = betId;
    }
    
    public String getBetId() {
        return betId;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    
    public double getNewPrice() {
        return newPrice;
    }

    private String betId;
    private double newPrice;
}
