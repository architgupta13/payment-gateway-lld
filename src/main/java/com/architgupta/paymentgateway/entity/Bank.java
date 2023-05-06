package main.java.com.architgupta.paymentgateway.entity;

import java.util.List;
import java.util.Random;

public class Bank {

    private String id;
    private String displayName;
    private List<Paymode> paymodeList;
    private Double successPercentage;
    private int successfulTransactions;
    private int failedTransactions;

    public List<Paymode> getPaymodeList() {
        return paymodeList;
    }

    public void setPaymodeList(List<Paymode> paymodeList) {
        this.paymodeList = paymodeList;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Double getSuccessPercentage() {
        return successPercentage;
    }

    public void setSuccessPercentage(Double successPercentage) {
        this.successPercentage = successPercentage;
    }

    public Bank(final String displayName, final Double successPercentage) {
        this.displayName = displayName;
        this.successPercentage = successPercentage;
    }

    public boolean getTransactionResult() {
        Random random = new Random();
        final boolean transactionResult = random.nextBoolean();
        if (transactionResult) {
            this.successfulTransactions += 1;
        } else {
            this.failedTransactions += 1;
        }
        this.successPercentage = (this.successfulTransactions * 100.0) / (this.successfulTransactions + this.failedTransactions);
        return random.nextBoolean();
    }
}
