package test.java.com.architgupta.paymentgateway;

import main.java.com.architgupta.paymentgateway.entity.Client;
import main.java.com.architgupta.paymentgateway.entity.Paymode;
import main.java.com.architgupta.paymentgateway.repository.BankRepository;
import main.java.com.architgupta.paymentgateway.repository.ClientRepository;
import main.java.com.architgupta.paymentgateway.service.OnboardingService;
import main.java.com.architgupta.paymentgateway.service.PaymentService;
import main.java.com.architgupta.paymentgateway.service.impl.OnboardingServiceImpl;
import main.java.com.architgupta.paymentgateway.service.impl.PaymentServiceImpl;
import main.java.com.architgupta.paymentgateway.strategy.payment.DefaultPaymentStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OnboardingServiceTest {

    public static final String SOME_CLIENT_NAME = "some-client-name";

    @Test
    public void testAddClient() {
        final ClientRepository flipkart = new ClientRepository();
        final BankRepository bankRepository = new BankRepository();
        final OnboardingService onboardingService = new OnboardingServiceImpl(flipkart);

        Assert.assertFalse(onboardingService.hasClient("some-client-id"));

        final String clientId = onboardingService.addClient(SOME_CLIENT_NAME);
        final Client addedClient = onboardingService.getClient(clientId);

        Assert.assertNotNull(addedClient);

        final PaymentService paymentService = new PaymentServiceImpl(bankRepository, flipkart, new DefaultPaymentStrategy());
        paymentService.addSupportForPayMode(SOME_CLIENT_NAME, Paymode.UPI);
        final List<Paymode> userVisiblePaymodeList = paymentService.listSupportedPayModes(SOME_CLIENT_NAME);
    }

    @Test
    public void testRemoveClient() {
        final ClientRepository clientRepository = new ClientRepository();
        final OnboardingService onboardingService = new OnboardingServiceImpl(clientRepository);

        final String clientId = onboardingService.addClient(SOME_CLIENT_NAME);
        Assert.assertTrue(onboardingService.hasClient(clientId));
        onboardingService.removeClient(clientId);
        Assert.assertFalse(onboardingService.hasClient(clientId));
    }
}
