package main.java.com.architgupta.paymentgateway.strategy.payment;

import main.java.com.architgupta.paymentgateway.entity.Bank;
import main.java.com.architgupta.paymentgateway.entity.Transaction;
import main.java.com.architgupta.paymentgateway.repository.BankRepository;

public interface PaymentStrategy {

    Bank getMostRelevantBank(BankRepository bankRepository, Transaction transaction);

    boolean transact(Bank bank, Transaction transaction);

}
