package main.java.com.architgupta.paymentgateway.entity;

public enum TransactionState {
    INITIATED,
    INSTRUMENT_VERIFIED,
    BANK_ALLOCATED,
    SUCCESS,
    FAILED,
    WAITING_ON_BANK
}
