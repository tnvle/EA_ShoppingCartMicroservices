package cs.mum.edu.paymentservice.service.impl;

import cs.mum.edu.paymentservice.model.BankAccount;
import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.service.BankAccountService;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public Boolean processPayment(BankAccount bankAccount, Payment payment) {
        return true;
    }
}
