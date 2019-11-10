package cs.mum.edu.paymentservice.service;

import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.model.Paypal;

public interface PaypalService {

    public Boolean processPayment(Paypal paypal, Payment payment);
}
