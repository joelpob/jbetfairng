package com.jbetfairng.entities;

public class RunnerProfitAndLoss {
    public void setSelectionId(long selectionId) {
        this.selectionId = selectionId;
    }
    
    public long getSelectionId() {
        return selectionId;
    }

    public void setIfWin(double ifWin) {
        this.ifWin = ifWin;
    }
    
    public double getIfWin() {
        return ifWin;
    }

    public void setIfLose(double ifLose) {
        this.ifLose = ifLose;
    }
    
    public double getIfLose() {
        return ifLose;
    }

    private long selectionId;
    private double ifWin;
    private double ifLose;
}
