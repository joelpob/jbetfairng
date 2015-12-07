package com.jbetfairng.entities;

import com.jbetfairng.enums.*;

public class UpdateInstruction {
    public void setBetId(String betId) {
        this.betId = betId;
    }
    
    public String getBetId() {
        return betId;
    }

    public void setNewPersistenceType(PersistenceType newPersistenceType) {
        this.newPersistenceType = newPersistenceType;
    }
    
    public PersistenceType getNewPersistenceType() {
        return newPersistenceType;
    }

    private String betId;
    private PersistenceType newPersistenceType;
}
