package com.jbetfairng.entities;

public class TimeRangeResult { 
    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }
    
    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }
    
    public int getMarketCount() {
        return marketCount;
    }

    private TimeRange timeRange;
    private int marketCount;
}
