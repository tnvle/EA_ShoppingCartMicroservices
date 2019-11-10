package cs.mum.edu.paymentservice.service;

import cs.mum.edu.paymentservice.entities.PaymentTransaction;

public interface PaymentService {
    public PaymentTransaction createPayment(PaymentTransaction paymentTransaction);
}
