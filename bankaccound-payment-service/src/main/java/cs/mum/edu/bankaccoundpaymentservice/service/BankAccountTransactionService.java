package cs.mum.edu.bankaccoundpaymentservice.service;

import cs.mum.edu.bankaccoundpaymentservice.entities.BankAccountTransaction;

public interface BankAccountTransactionService {
    public BankAccountTransaction createTransaction(BankAccountTransaction bankAccountTransaction);
}
