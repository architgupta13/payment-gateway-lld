package main.java.com.architgupta.paymentgateway.strategy.payment;

import main.java.com.architgupta.paymentgateway.entity.Bank;
import main.java.com.architgupta.paymentgateway.entity.Transaction;
import main.java.com.architgupta.paymentgateway.repository.BankRepository;

public class DefaultPaymentStrategy implements PaymentStrategy {
    @Override
    public Bank getMostRelevantBank(BankRepository bankRepository, Transaction transaction) {
        return bankRepository.getAnyBank();
    }

    @Override
    public boolean transact(Bank bank, Transaction transaction) {
        return bank.getTransactionResult();
    }
}
