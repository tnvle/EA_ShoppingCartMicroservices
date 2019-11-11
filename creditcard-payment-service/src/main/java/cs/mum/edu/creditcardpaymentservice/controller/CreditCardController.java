package cs.mum.edu.creditcardpaymentservice.controller;

import cs.mum.edu.creditcardpaymentservice.entities.CreditCardTransaction;
import cs.mum.edu.creditcardpaymentservice.model.CreditCard;
import cs.mum.edu.creditcardpaymentservice.model.PaymentDTO;
import cs.mum.edu.creditcardpaymentservice.service.CreditCardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardTransactionService creditCardTransactionService;

    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:vanapikey}")
    private String apiKey;

    @PostMapping("/process")
    public @ResponseBody
    Long processPayment(@RequestBody PaymentDTO paymentDTO, @RequestHeader(name="APIKey", required = false) String apikey){
        //verify API token
        if(this.apiKey.compareTo(apikey)!=0)
            return Long.valueOf(-1);

        CreditCardTransaction transaction = new CreditCardTransaction();
        transaction.setCardname(((CreditCard)paymentDTO.getPayment()).getCardname());
        transaction.setCardnumber(((CreditCard)paymentDTO.getPayment()).getCardnumber());
        transaction.setTotal(paymentDTO.getTotal());
        transaction.setCreated(new Date());
        creditCardTransactionService.save(transaction);
        return transaction.getId();
    }
}
