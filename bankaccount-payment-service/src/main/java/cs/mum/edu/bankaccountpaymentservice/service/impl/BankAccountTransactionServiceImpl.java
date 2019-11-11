package cs.mum.edu.bankaccountpaymentservice.service.impl;

import cs.mum.edu.bankaccountpaymentservice.entities.BankAccountTransaction;
import cs.mum.edu.bankaccountpaymentservice.repository.BankAccountTransactionRepository;
import cs.mum.edu.bankaccountpaymentservice.service.BankAccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BankAccountTransactionServiceImpl implements BankAccountTransactionService {
    @Autowired
    private BankAccountTransactionRepository bankAccountTransactionRepository;

    @Override
    public BankAccountTransaction save(BankAccountTransaction bankAccountTransaction) {
//        bankAccountTransaction.setCreated(new Date());
        return bankAccountTransactionRepository.save(bankAccountTransaction);
    }
}
