package com.jbetfairng.entities;

import java.util.List;

public class AccountStatementReport { 
    public void setAccountStatement(List<StatementItem> accountStatement) {
        this.accountStatement = accountStatement;
    }
    
    public List<StatementItem> getAccountStatement() {
        return accountStatement;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }
    
    public boolean getMoreAvailable() {
        return moreAvailable;
    }

    private List<StatementItem> accountStatement;
    private boolean moreAvailable;
}
