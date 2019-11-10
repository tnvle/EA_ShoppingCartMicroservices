package cs.mum.edu.paymentservice.service;

import cs.mum.edu.paymentservice.model.CreditCard;
import cs.mum.edu.paymentservice.model.Payment;

public interface CreditCardService {
    public Boolean processPayment(CreditCard creditCard, Payment payment);
}
