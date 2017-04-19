package com.jbetfairng.entities;

import com.jbetfairng.enums.*;

public class UpdateInstructionReport {
    public void setStatus(InstructionReportStatus status) {
        this.status = status;
    }
    
    public InstructionReportStatus getStatus() {
        return status;
    }

    public void setErrorCode(InstructionReportErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    
    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public void setInstruction(UpdateInstruction instruction) {
        this.instruction = instruction;
    }
    
    public UpdateInstruction getInstruction() {
        return instruction;
    }

    private InstructionReportStatus status;
    private InstructionReportErrorCode errorCode;
    private UpdateInstruction instruction;
}
