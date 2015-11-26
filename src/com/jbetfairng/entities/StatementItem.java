package com.jbetfairng.entities;

import com.jbetfairng.enums.ItemClass;
import com.jbetfairng.entities.StatementLegacyData;

import java.util.Date;
import java.util.Set;
import java.util.Map;

public class StatementItem {
    public void setRefId(String refId) {
        this.refId = refId;
    }
    
    public String getRefId() {
        return refId;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }
    
    public Date getItemDate() {
        return itemDate;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setItemClass(ItemClass itemClass) {
        this.itemClass = itemClass;
    }
    
    public ItemClass getItemClass() {
        return itemClass;
    }

    public void setItemClassData(Map<String, String> itemClassData) {
        this.itemClassData = itemClassData;
    }
    
    public Map<String, String> getItemClassData() {
        return itemClassData;
    }

    public void setLegacyData(StatementLegacyData legacyData) {
        this.legacyData = legacyData;
    }
    
    public StatementLegacyData getLegacyData() {
        return legacyData;
    }

    private String refId;
    private Date itemDate;
    private double amount;
    private double balance;
    private ItemClass itemClass;
    private Map<String, String> itemClassData;
    private StatementLegacyData legacyData;
}
