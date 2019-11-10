package cs.mum.edu.paymentservice.service.impl;

import cs.mum.edu.paymentservice.model.CreditCard;
import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.service.CreditCardService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Override
    public Boolean processPayment(CreditCard creditCard, Payment payment) {
        return true;
    }
}
