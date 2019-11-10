package cs.mum.edu.bankaccountpaymentservice.controller;

import cs.mum.edu.bankaccountpaymentservice.entities.BankAccountTransaction;
import cs.mum.edu.bankaccountpaymentservice.model.PaymentDTO;
import cs.mum.edu.bankaccountpaymentservice.service.BankAccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountTransactionService bankAccountTransactionService;

    @PostMapping("/process")
    public @ResponseBody Long processPayment(@RequestBody PaymentDTO paymentDTO){
        BankAccountTransaction transaction = new BankAccountTransaction();
        transaction.setBankAccount(paymentDTO.getPayment().getAccount());
        transaction.setTotal(paymentDTO.getTotal());
        transaction.setCreated(new Date());
        return bankAccountTransactionService.createTransaction(transaction).getId();
    }
}
