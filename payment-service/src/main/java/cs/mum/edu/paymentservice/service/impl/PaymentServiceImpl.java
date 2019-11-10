package cs.mum.edu.paymentservice.service.impl;

import cs.mum.edu.paymentservice.model.BankAccount;
import cs.mum.edu.paymentservice.model.CreditCard;
import cs.mum.edu.paymentservice.entities.Payment;
import cs.mum.edu.paymentservice.model.Paypal;
import cs.mum.edu.paymentservice.repository.PaymentRepository;
import cs.mum.edu.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
//        switch (payment.getPaymentType()){
//            case Paypal:
//                payment.setSuccessStatus(paypalService.processPayment(new Paypal(), payment));
//                break;
//            case BankAccount:
//                payment.setSuccessStatus(bankAccountService.processPayment(new BankAccount(), payment));
//                break;
//            case CreditCard:
//                payment.setSuccessStatus(creditCardService.processPayment(new CreditCard(), payment));
//                break;
//        }
        return paymentRepository.save(payment);
    }
}
