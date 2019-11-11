package cs.mum.edu.paypalpaymentservice.controller;

import cs.mum.edu.paypalpaymentservice.entities.PaypalTransaction;
import cs.mum.edu.paypalpaymentservice.model.PaymentDTO;
import cs.mum.edu.paypalpaymentservice.model.Paypal;
import cs.mum.edu.paypalpaymentservice.service.PaypalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PaypalController {

    @Autowired
    private PaypalTransactionService paypalTransactionService;

    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:vanapikey}")
    private String apiKey;

    @PostMapping("/process")
    public @ResponseBody
    Long processPayment(@RequestBody PaymentDTO paymentDTO, @RequestHeader(name="APIKey", required = false) String apikey){

        if(apikey == null || apikey.trim().length()== 0)
            return Long.valueOf(-2);

        //verify API token
        if(this.apiKey.compareTo(apikey)!=0)
            return Long.valueOf(-1);

        PaypalTransaction transaction = new PaypalTransaction();
        transaction.setAccount(((Paypal)paymentDTO.getPayment()).getAccount());
        transaction.setTotal(paymentDTO.getTotal());
        transaction.setCreated(new Date());
        paypalTransactionService.save(transaction);
        return transaction.getId();
    }
}
