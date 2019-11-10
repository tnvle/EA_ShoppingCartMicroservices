package cs.mum.edu.paymentservice.service.impl;

import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.model.Paypal;
import cs.mum.edu.paymentservice.service.PaypalService;
import org.springframework.stereotype.Service;

@Service
public class PaypalServiceImpl implements PaypalService {
    @Override
    public Boolean processPayment(Paypal paypal, Payment payment) {
        return true;
    }
}
