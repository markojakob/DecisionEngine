package com.example.decisionengine.Service;


import com.example.decisionengine.Dto.Request.DecisionRequest;
import com.example.decisionengine.Dto.Response.DecisionResponse;
import org.springframework.stereotype.Service;

@Service
public class DecisionService {
    private final CreditService creditService;

    public DecisionService(CreditService creditService) {
        this.creditService = creditService;
    }

    public DecisionResponse calculateDecision(DecisionRequest request) {
        DecisionResponse response = new DecisionResponse();
        response.setPersonalCode(request.getPersonalCode());
        response.setLoanAmount(request.getLoanAmount());

        int stepSize = 50;
        int maxAmount = 10000;
        int minAmount = 2000;
        int maxPeriod = 60;
        int minPeriod = 12;

        int approvedAmount = 0;
        int approvedPeriod = 0;

        int creditModifier = creditService.getCreditModifier(request.getPersonalCode());

        if (creditModifier == -1) { // debt
            response.setApproved(false);
            response.setApprovedAmount(0);
            response.setPeriod(Math.max(request.getPeriod(), minPeriod));
            return response;
        }

        int period = Math.max(request.getPeriod(), minPeriod);

        while (period <= maxPeriod && approvedAmount == 0) {
            int amount = maxAmount;
            while (amount >= minAmount) {
                double creditScore = (double) creditModifier / amount * period;
                if (creditScore >= 1) {
                    approvedAmount = amount;
                    approvedPeriod = period;
                    break;
                }
                amount -= stepSize;
            }
            period++;
        }

        response.setApproved(approvedAmount > 0);
        response.setApprovedAmount(approvedAmount);
        response.setPeriod(approvedPeriod > 0 ? approvedPeriod : Math.max(request.getPeriod(), minPeriod));

        return response;
    }
}

