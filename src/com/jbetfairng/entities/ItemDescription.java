package com.jbetfairng.entities;

import java.util.Date;
import java.util.List;

public class ItemDescription {
	public void setEventTypeDesc(String eventTypeDesc) {
		this.eventTypeDesc = eventTypeDesc;
	}
	
	public String getEventTypeDesc() {
		return eventTypeDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	
	public String getEventDesc() {
		return eventDesc;
	}

	public void setMarketDesc(String marketDesc) {
		this.marketDesc = marketDesc;
	}
	
	public String getMarketDesc() {
		return marketDesc;
	}

	public void setMarketStartTime(Date marketStartTime) {
		this.marketStartTime = marketStartTime;
	}
	
	public Date getMarketStartTime() {
		return marketStartTime;
	}

	public void setRunnerDesc(String runnerDesc) {
		this.runnerDesc = runnerDesc;
	}
	
	public String getRunnerDesc() {
		return runnerDesc;
	}

	public void setNumberOfWinners(int numberOfWinners) {
		this.numberOfWinners = numberOfWinners;
	}
	
	public int getNumberOfWinners() {
		return numberOfWinners;
	}
	
	private String eventTypeDesc;
	private String eventDesc;
	private String marketDesc;
	private Date marketStartTime;
	private String runnerDesc;
	private int numberOfWinners;
}

