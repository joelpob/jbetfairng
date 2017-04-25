package com.jbetfairng.entities;

import java.util.List;

public class CurrentOrderSummaryReport {
    public List<CurrentOrderSummary> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<CurrentOrderSummary> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    private List<CurrentOrderSummary> currentOrders;
    private boolean moreAvailable;
}
