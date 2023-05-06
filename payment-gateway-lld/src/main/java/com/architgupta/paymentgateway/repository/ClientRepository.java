package main.java.com.architgupta.paymentgateway.repository;

import main.java.com.architgupta.paymentgateway.entity.Client;

import java.util.*;

public class ClientRepository {
    private List<String> clientIds;
    private Map<String, Client> clients;

    public ClientRepository() {
        this.clientIds = new ArrayList<>();
        this.clients = new HashMap<>();
    }

    public Client getClient(final String id) {
        if (this.clientIds.contains(id)) {
            return this.clients.get(id);
        }
        return null;
    }

    public boolean hasClient(final String id) {
        return this.clientIds.contains(id);
    }

    public String setClient(final Client client) {
        String id;
        if (hasClient(client.getId())) {
            id = client.getId();
            this.clients.put(client.getId(), client);
        } else {
            id = String.valueOf(UUID.randomUUID());
            this.clients.put(id, client);
            this.clientIds.add(id);
        }
        return id;
    }

    public void remove(final String id) {
        if (!hasClient(id)) {
            return;
        }
        this.clients.remove(id);
        this.clientIds.remove(id);
    }
}
