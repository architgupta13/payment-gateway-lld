package main.java.com.architgupta.paymentgateway.model.response;

public class DistributionResponse {
    private String bankName;
    private Double successPercentage;

    public DistributionResponse(String bankName, Double successPercentage) {
        this.bankName = bankName;
        this.successPercentage = successPercentage;
    }
}
