package cs.mum.edu.paymentservice.service.impl;

import cs.mum.edu.paymentservice.entities.PaymentTransaction;
import cs.mum.edu.paymentservice.repository.PaymentRepository;
import cs.mum.edu.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentTransaction createPayment(PaymentTransaction paymentTransaction) {
//        switch (paymentTransaction.getPaymentType()){
//            case Paypal:
//                paymentTransaction.setSuccessStatus(paypalService.processPayment(new Paypal(), paymentTransaction));
//                break;
//            case BankAccount:
//                paymentTransaction.setSuccessStatus(bankAccountService.processPayment(new BankAccount(), paymentTransaction));
//                break;
//            case CreditCard:
//                paymentTransaction.setSuccessStatus(creditCardService.processPayment(new CreditCard(), paymentTransaction));
//                break;
//        }
        return paymentRepository.save(paymentTransaction);
    }
}
