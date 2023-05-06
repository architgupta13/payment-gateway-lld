package main.java.com.architgupta.paymentgateway.strategy.instrument;

import main.java.com.architgupta.paymentgateway.entity.Paymode;

import java.util.Map;

public interface InstrumentStrategy {

    boolean verifyInstrument(Paymode paymode, Map<String, String> paymodeDetail);

}
