package cs.mum.edu.paypalpaymentservice.service.impl;


import cs.mum.edu.paypalpaymentservice.entities.PaypalTransaction;
import cs.mum.edu.paypalpaymentservice.repository.PaypalTransactionRepository;
import cs.mum.edu.paypalpaymentservice.service.PaypalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaypalTransactionServiceImpl implements PaypalTransactionService {
    @Autowired
    private PaypalTransactionRepository paypalTransactionRepository;

    @Override
    public PaypalTransaction save(PaypalTransaction paypalTransaction) {

        return paypalTransactionRepository.save(paypalTransaction);
    }
}
