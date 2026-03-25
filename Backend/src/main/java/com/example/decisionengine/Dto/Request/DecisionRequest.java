package com.example.decisionengine.Dto.Request;

public class DecisionRequest {

    String personalCode;
    int loanAmount;
    int period;

    public DecisionRequest(String personalCode, int loanAmount, int period) {
        this.loanAmount = loanAmount;
        this.period = period;
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
