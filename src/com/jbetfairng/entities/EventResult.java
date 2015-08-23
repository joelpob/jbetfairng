package com.jbetfairng.entities;

public class EventResult {
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) { this.event = event; }

    public EventType getEventType() { return eventType; }

    public void setEventType(EventType eventType) { this.eventType = eventType; }

    public int getMarketCount() {
        return marketCount;
    }

    public void setMarketCount(int marketCount) {
        this.marketCount = marketCount;
    }

    private Event event;
    private EventType eventType;
    private int marketCount;

}
