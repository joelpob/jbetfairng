package com.jbetfairng.entities;

import com.jbetfairng.enums.Side;
import com.jbetfairng.enums.OrderStatus;
import com.jbetfairng.enums.PersistenceType;
import com.jbetfairng.enums.OrderType;

import java.util.Date;

public class ClearedOrderSummary {
    public void setEventTypeId(String eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
    
    public String getEventTypeId() {
        return eventTypeId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    
    public String getEventId() {
        return eventId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    
    public String getMarketId() {
        return marketId;
    }

    public void setSelectionId(long selectionId) {
        this.selectionId = selectionId;
    }
    
    public long getSelectionId() {
        return selectionId;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }
    
    public double getHandicap() {
        return handicap;
    }

    public void setBetId(String betId) {
        this.betId = betId;
    }
    
    public String getBetId() {
        return betId;
    }

    public void setPlacedDate(Date placedDate) {
        this.placedDate = placedDate;
    }
    
    public Date getPlacedDate() {
        return placedDate;
    }
    
    public void setPersistenceType(PersistenceType persistenceType) {
        this.persistenceType = persistenceType;
    }
    
    public PersistenceType getPersistenceType() {
        return persistenceType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    
    public OrderType getOrderType() {
        return orderType;
    }

    public void setSide(Side side) {
        this.side = side;
    }
    
    public Side getSide() {
        return side;
    }

    public void setItemDescription(ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }
    
    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    private String eventTypeId;
    private String eventId;
    private String marketId;
    private long selectionId;
    private double handicap;
    private String betId;
    private Date placedDate;
    private PersistenceType persistenceType;
    private OrderType orderType; 
    private Side side;
    private ItemDescription itemDescription;
}

    
