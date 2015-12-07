package com.jbetfairng.entities;

import java.util.List;

import com.jbetfairng.enums.*;

public class ReplaceExecutionReport {
    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }
    
    public String getCustomerRef() {
        return customerRef;
    }

    public void setStatus(ExecutionReportStatus status) {
        this.status = status;
    }
    
    public ExecutionReportStatus getStatus() {
        return status;
    }

    public void setErrorCode(ExecutionReportErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    
    public ExecutionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    
    public String getMarketId() {
        return marketId;
    }

    public void setInstructionReports(List<ReplaceInstructionReport> instructionReports) {
        this.instructionReports = instructionReports;
    }
    
    public List<ReplaceInstructionReport> getInstructionReports() {
        return instructionReports;
    }

    private String customerRef;
    private ExecutionReportStatus status;
    private ExecutionReportErrorCode errorCode;
    private String marketId;
    private List<ReplaceInstructionReport> instructionReports;
}
