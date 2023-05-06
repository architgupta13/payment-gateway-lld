package main.java.com.architgupta.paymentgateway.service;

import main.java.com.architgupta.paymentgateway.entity.Client;

public interface OnboardingService {

    String addClient(String displayName);

    void removeClient(String clientId);

    boolean hasClient(String clientId);

    Client getClient(String clientId);

}
