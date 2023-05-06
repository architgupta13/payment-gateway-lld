package main.java.com.architgupta.paymentgateway.service.impl;

import main.java.com.architgupta.paymentgateway.entity.Client;
import main.java.com.architgupta.paymentgateway.repository.ClientRepository;
import main.java.com.architgupta.paymentgateway.service.OnboardingService;

import java.util.ArrayList;

public class OnboardingServiceImpl implements OnboardingService {

    private final ClientRepository clientRepository;

    public OnboardingServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public String addClient(final String displayName) {
        return this.clientRepository.setClient(new Client(displayName, new ArrayList<>()));
    }

    @Override
    public void removeClient(final String clientId) {
        this.clientRepository.remove(clientId);
    }

    @Override
    public boolean hasClient(final String clientId) {
        return this.clientRepository.hasClient(clientId);
    }

    @Override
    public Client getClient(String clientId) {
        return this.clientRepository.getClient(clientId);
    }

}
