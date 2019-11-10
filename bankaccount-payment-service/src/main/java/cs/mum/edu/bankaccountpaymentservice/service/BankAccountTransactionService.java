package cs.mum.edu.bankaccountpaymentservice.service;

import cs.mum.edu.bankaccountpaymentservice.entities.BankAccountTransaction;

public interface BankAccountTransactionService {
    public BankAccountTransaction createTransaction(BankAccountTransaction bankAccountTransaction);
}
