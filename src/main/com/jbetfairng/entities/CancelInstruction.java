package com.jbetfairng.entities;

public class CancelInstruction {
    public void setBetId(String betId) {
        this.betId = betId;
    }
    
    public String getBetId() {
        return betId;
    }

    public void setSizeReduction(double sizeReduction) {
        this.sizeReduction = sizeReduction;
    }
    
    public double getSizeReduction() {
        return sizeReduction;
    }

    private String betId;
    private double sizeReduction;
}
