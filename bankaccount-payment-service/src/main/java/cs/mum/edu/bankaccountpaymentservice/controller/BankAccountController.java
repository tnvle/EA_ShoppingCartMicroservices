package cs.mum.edu.bankaccountpaymentservice.controller;

import cs.mum.edu.bankaccountpaymentservice.entities.BankAccountTransaction;
import cs.mum.edu.bankaccountpaymentservice.model.PaymentDTO;
import cs.mum.edu.bankaccountpaymentservice.service.BankAccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountTransactionService bankAccountTransactionService;

    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:vanapikey}")
    private String apiKey;

    @PostMapping("/process")
    public @ResponseBody Long processPayment(@RequestBody PaymentDTO paymentDTO, @RequestHeader(name="APIKey", required = false) String apikey){
        //verify API token
        if(this.apiKey.compareTo(apikey)!=0)
            return Long.valueOf(-1);

        BankAccountTransaction transaction = new BankAccountTransaction();
        transaction.setBankAccount(paymentDTO.getPayment().getAccount());
        transaction.setTotal(paymentDTO.getTotal());
        transaction.setCreated(new Date());
        return bankAccountTransactionService.createTransaction(transaction).getId();
    }
}
