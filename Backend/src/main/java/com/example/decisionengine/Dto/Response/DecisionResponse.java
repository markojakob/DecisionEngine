package com.example.decisionengine.Dto.Response;

public class DecisionResponse {

    String personalCode;
    int loanAmount;
    int period;
    private boolean approved;
    private int approvedAmount;

    public DecisionResponse(){
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public int getPeriod() {
        return period;
    }

    public int getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(int approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
