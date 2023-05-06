package main.java.com.architgupta.paymentgateway.service.impl;

import main.java.com.architgupta.paymentgateway.entity.Bank;
import main.java.com.architgupta.paymentgateway.entity.Client;
import main.java.com.architgupta.paymentgateway.entity.Paymode;
import main.java.com.architgupta.paymentgateway.entity.Transaction;
import main.java.com.architgupta.paymentgateway.model.request.TransactionRequest;
import main.java.com.architgupta.paymentgateway.model.response.DistributionResponse;
import main.java.com.architgupta.paymentgateway.repository.BankRepository;
import main.java.com.architgupta.paymentgateway.repository.ClientRepository;
import main.java.com.architgupta.paymentgateway.service.PaymentService;
import main.java.com.architgupta.paymentgateway.strategy.instrument.InstrumentStrategy;
import main.java.com.architgupta.paymentgateway.strategy.payment.PaymentStrategy;

import java.util.Arrays;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private final BankRepository bankRepository;
    private final ClientRepository clientRepository;
    private PaymentStrategy paymentStrategy;
    private InstrumentStrategy instrumentStrategy;

    public PaymentServiceImpl(final BankRepository bankRepository, final ClientRepository clientRepository, final PaymentStrategy paymentStrategy) {
        this.bankRepository = bankRepository;
        this.clientRepository = clientRepository;
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public List<Paymode> listSupportedPayModes() {
        return Arrays.stream(Paymode.values())
                .toList();
    }

    @Override
    public List<Paymode> listSupportedPayModes(final String clientId) {
        final Client client = this.clientRepository.getClient(clientId);
        return client.getSupportedPayModes();
    }

    @Override
    public void addSupportForPayMode(final String clientId, final Paymode newPaymode) {
        final Client client = this.clientRepository.getClient(clientId);
        client.addSupportedPaymode(newPaymode);
    }

    @Override
    public void removePayMode(final String clientId, final Paymode paymodeToDelete) {
        final Client client = this.clientRepository.getClient(clientId);
        client.removeSupportedPaymode(paymodeToDelete);
    }

    @Override
    public List<DistributionResponse> showDistribution() {
        return this.bankRepository.getAllBanks()
                .stream()
                .map(bank -> new DistributionResponse(bank.getDisplayName(), bank.getSuccessPercentage()))
                .toList();
    }

    @Override
    public boolean makePayment(final TransactionRequest transactionRequest) {
        if (!this.instrumentStrategy.verifyInstrument(transactionRequest.getPaymodeToUse(), transactionRequest.getPaymentDetails()))  {
            throw new RuntimeException("Payment details are not valid");
        }

        final Client client = this.clientRepository.getClient(transactionRequest.getClientId());
        final Transaction transaction = toTransaction(transactionRequest);
        final Bank bank = this.paymentStrategy.getMostRelevantBank(this.bankRepository, transaction);
        return this.paymentStrategy.transact(bank, transaction);
    }

    private Transaction toTransaction(TransactionRequest transactionRequest) {
        return null;
    }
}
