package com.jbetfairng.entities;

import com.jbetfairng.entities.RunnerProfitAndLoss;
import java.util.List;

public class MarketProfitAndLoss {
    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    
    public String getMarketId() {
        return marketId;
    }

    public void setCommissionApplied(double commissionApplied) {
        this.commissionApplied = commissionApplied;
    }
    
    public double getCommissionApplied() {
        return commissionApplied;
    }

    public void setProfitAndLosses(List<RunnerProfitAndLoss> profitAndLosses) {
        this.profitAndLosses = profitAndLosses;
    }
    
    public List<RunnerProfitAndLoss> getProfitAndLosses() {
        return profitAndLosses;
    }

    private String marketId;
    private double commissionApplied;
    private List<RunnerProfitAndLoss> profitAndLosses;

}
