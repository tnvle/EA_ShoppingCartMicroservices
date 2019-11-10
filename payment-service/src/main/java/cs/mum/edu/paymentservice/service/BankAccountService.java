package cs.mum.edu.paymentservice.service;

import cs.mum.edu.paymentservice.model.BankAccount;
import cs.mum.edu.paymentservice.model.Payment;

public interface BankAccountService {
    public Boolean processPayment(BankAccount bankAccount, Payment payment);
}
