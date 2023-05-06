package main.java.com.architgupta.paymentgateway.repository;

import main.java.com.architgupta.paymentgateway.entity.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {

    private List<String> bankIds;
    private Map<String, Bank> banks;
    private String prioritisedBankId;
    private Double minimumThresholdForEligibility;

    public BankRepository() {
        this.bankIds = new ArrayList<>() {{
            add("bank1");
            add("bank2");
            add("bank3");
            add("bank4");
            add("bank5");
        }};
        this.banks = loadBanks();
        this.prioritisedBankId = this.bankIds.get(0);
    }

    public Bank getBank(final String id) {
        if (this.bankIds.contains(id)) {
            return this.banks.get(id);
        }
        return null;
    }

    public boolean hasBank(final String id) {
        return this.bankIds.contains(id);
    }

    public Bank getAnyBank() {
        return this.banks.get("bank2");
    }

    public List<Bank> getAllBanks() {
        return this.banks.values()
                .stream()
                .toList();

    }

    private Map<String, Bank> loadBanks() {
        final Bank bank1 = new Bank("HDFC", 100.0);
        final Bank bank2 = new Bank("SBI", 100.0);
        final Bank bank3 = new Bank("ICICI", 100.0);
        final Bank bank4 = new Bank("Axis", 100.0);
        final Bank bank5 = new Bank("PNB", 100.0);

        Map<String, Bank> banks = new HashMap<>();
        banks.put("bank1", bank1);
        banks.put("bank2", bank2);
        banks.put("bank3", bank3);
        banks.put("bank4", bank4);
        banks.put("bank5", bank5);
        return banks;
    }

}
