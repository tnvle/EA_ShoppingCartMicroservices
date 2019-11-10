package cs.mum.edu.bankaccoundpaymentservice.controller;

import cs.mum.edu.bankaccoundpaymentservice.model.BankAccountTransaction;
import cs.mum.edu.bankaccoundpaymentservice.service.BankAccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {
    @Autowired
    private BankAccountTransactionService bankAccountTransactionService;

    @PostMapping
    public @ResponseBody Long processPayment(@RequestBody BankAccountTransaction bankAccount){
        return bankAccountTransactionService.createTransaction(bankAccount).getId();
    }
}
