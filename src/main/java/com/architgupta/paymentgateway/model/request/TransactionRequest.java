package main.java.com.architgupta.paymentgateway.model.request;

import main.java.com.architgupta.paymentgateway.entity.Paymode;

import java.util.Map;

public class TransactionRequest {
    private String clientId;
    private Double amount;
    private Paymode paymodeToUse;
    private Map<String, String> paymentDetails;

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Map<String, String> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Paymode getPaymodeToUse() {
        return paymodeToUse;
    }

    public void setPaymodeToUse(Paymode paymodeToUse) {
        this.paymodeToUse = paymodeToUse;
    }

    public TransactionRequest(String clientId, Double amount, Paymode paymodeToUse, Map<String, String> paymentDetails) {
        this.clientId = clientId;
        this.amount = amount;
        this.paymodeToUse = paymodeToUse;
        this.paymentDetails = paymentDetails;
    }
}
