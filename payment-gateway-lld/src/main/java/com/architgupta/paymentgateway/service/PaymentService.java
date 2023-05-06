package main.java.com.architgupta.paymentgateway.service;

import main.java.com.architgupta.paymentgateway.entity.Paymode;
import main.java.com.architgupta.paymentgateway.model.request.TransactionRequest;
import main.java.com.architgupta.paymentgateway.model.response.DistributionResponse;

import java.util.List;

public interface PaymentService {

    List<Paymode> listSupportedPayModes();

    List<Paymode> listSupportedPayModes(String clientId);

    void addSupportForPayMode(String clientId, Paymode newPaymode);

    void removePayMode(String clientId, Paymode paymodeToDelete);

    List<DistributionResponse> showDistribution();

    boolean makePayment(TransactionRequest transactionRequest);

}
