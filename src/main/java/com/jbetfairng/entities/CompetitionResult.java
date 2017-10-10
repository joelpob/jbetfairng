package com.jbetfairng.entities;

public class CompetitionResult {
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getMarketCount() {
        return marketCount;
    }

    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }

    public String getCompetitionRegion() {
        return competitionRegion;
    }

    public void setCompetitionRegion(String competitionRegion) {
        this.competitionRegion = competitionRegion;
    }

    private Competition competition;
    private int marketCount;
    private String competitionRegion;
}