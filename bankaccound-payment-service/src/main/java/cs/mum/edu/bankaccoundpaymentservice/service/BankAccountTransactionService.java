package cs.mum.edu.bankaccoundpaymentservice.service;

import cs.mum.edu.bankaccoundpaymentservice.model.BankAccountTransaction;

public interface BankAccountTransactionService {
    public BankAccountTransaction createTransaction(BankAccountTransaction bankAccountTransaction);
}
