package com.jbetfairng.entities;

import java.util.Date;

public class StatementLegacyData {
    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
    
    public double getAveragePrice() {
        return averagePrice;
    }

    public void setBetSize(double betSize) {
        this.betSize = betSize;
    }
    
    public double getBetSize() {
        return betSize;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }
    
    public String getBetType() {
        return betType;
    }

    public void setBetCategoryType(String betCategoryType) {
        this.betCategoryType = betCategoryType;
    }
    
    public String getBetCategoryType() {
        return betCategoryType;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    public String getCommissionRate() {
        return commissionRate;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
    
    public long getEventId() {
        return eventId;
    }

    public void setEventTypeId(long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
    
    public long getEventTypeId() {
        return eventTypeId;
    }

    public void setFullMarketName(String fullMarketName) {
        this.fullMarketName = fullMarketName;
    }
    
    public String getFullMarketName() {
        return fullMarketName;
    }

    public void setGrossBetAmount(double grossBetAmount) {
        this.grossBetAmount = grossBetAmount;
    }
    
    public double getGrossBetAmount() {
        return grossBetAmount;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
    
    public String getMarketName() {
        return marketName;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
    
    public String getMarketType() {
        return marketType;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }
    
    public Date getPlacedDate() {
        return placedDate;
    }

    public void setSelectionId(long selectionId) {
        this.selectionId = selectionId;
    }
    
    public long getSelectionId() {
        return selectionId;
    }

    public void setSelectionName(String selectionName) {
        this.selectionName = selectionName;
    }
    
    public String getSelectionName() {
        return selectionName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    
    public long getTransactionId() {
        return transactionId;
    }

    public void setWinLose(String winLose) {
        this.winLose = winLose;
    }
    
    public String getWinLose() {
        return winLose;
    }

    private double averagePrice;
    private double betSize;
    private String betType;
    private String betCategoryType;
    private String commissionRate;
    private long eventId;
    private long eventTypeId;
    private String fullMarketName;
    private double grossBetAmount;
    private String marketName;
    private String marketType;
    private Date placedDate;
    private long selectionId;
    private String selectionName;
    private Date startDate;
    private String transactionType;
    private long transactionId;
    private String winLose;
}
