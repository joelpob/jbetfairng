package com.jbetfairng.entities;

public class VenueResult { 
    public void setVenue(String venue) {
        this.venue = venue;
    }
    
    public String getVenue() {
        return venue;
    }

    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }
    
    public int getMarketCount() {
        return marketCount;
    }

    private String venue;
    private int marketCount;
}
