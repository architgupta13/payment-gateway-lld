package main.java.com.architgupta.paymentgateway.entity;

public class Transaction {
    private String bankId;
    private String clientId;
    private Paymode paymodeUsed;
    private TransactionState state;
    private Double amount;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Paymode getPaymodeUsed() {
        return paymodeUsed;
    }

    public void setPaymodeUsed(Paymode paymodeUsed) {
        this.paymodeUsed = paymodeUsed;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction(String clientId, Paymode paymodeUsed, TransactionState state, Double amount) {
        this.clientId = clientId;
        this.paymodeUsed = paymodeUsed;
        this.state = state;
        this.amount = amount;
    }
}
