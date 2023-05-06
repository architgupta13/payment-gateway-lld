package main.java.com.architgupta.paymentgateway.entity;

import java.util.List;

public class Client {
    private String id;
    private String displayName;
    private List<Paymode> supportedPayModes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Paymode> getSupportedPayModes() {
        return supportedPayModes;
    }

    public void setSupportedPayModes(List<Paymode> supportedPayModes) {
        this.supportedPayModes = supportedPayModes;
    }

    public void addSupportedPaymode(Paymode paymode) {
        this.supportedPayModes.add(paymode);
    }

    public void removeSupportedPaymode(Paymode paymode) {
        this.supportedPayModes.remove(paymode);
    }

    public Client(String displayName, List<Paymode> supportedPayModes) {
        this.displayName = displayName;
        this.supportedPayModes = supportedPayModes;
    }
}
