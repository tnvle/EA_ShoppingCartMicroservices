package cs.mum.edu.bankaccoundpaymentservice.service.impl;

import cs.mum.edu.bankaccoundpaymentservice.model.BankAccountTransaction;
import cs.mum.edu.bankaccoundpaymentservice.repository.BankAccountTransactionRepository;
import cs.mum.edu.bankaccoundpaymentservice.service.BankAccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BankAccountTransactionServiceImpl implements BankAccountTransactionService {
    @Autowired
    private BankAccountTransactionRepository bankAccountTransactionRepository;

    @Override
    public BankAccountTransaction createTransaction(BankAccountTransaction bankAccountTransaction) {
        bankAccountTransaction.setCreated(new Date());
        return bankAccountTransactionRepository.save(bankAccountTransaction);
    }
}
