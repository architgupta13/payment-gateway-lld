package main.java.com.architgupta.paymentgateway.strategy.instrument;

import main.java.com.architgupta.paymentgateway.entity.Paymode;

import java.util.Map;

public class DefaultInstrumentStrategy implements InstrumentStrategy {
    @Override
    public boolean verifyInstrument(Paymode paymode, Map<String, String> paymodeDetail) {
        return true;
    }
}
