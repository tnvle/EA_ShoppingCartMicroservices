package cs.mum.edu.creditcardpaymentservice.service.impl;

import cs.mum.edu.creditcardpaymentservice.entities.CreditCardTransaction;
import cs.mum.edu.creditcardpaymentservice.repository.CreditCardTransactionRepository;
import cs.mum.edu.creditcardpaymentservice.service.CreditCardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService {
    @Autowired
    private CreditCardTransactionRepository creditCardTransactionRepository;

    @Override
    public CreditCardTransaction save(CreditCardTransaction creditCardTransaction) {

        return creditCardTransactionRepository.save(creditCardTransaction);
    }
}
