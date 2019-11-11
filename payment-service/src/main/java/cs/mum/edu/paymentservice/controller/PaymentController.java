package cs.mum.edu.paymentservice.controller;

import cs.mum.edu.paymentservice.entities.PaymentTransaction;
import cs.mum.edu.paymentservice.model.BankAccount;
import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.model.PaymentDTO;
import cs.mum.edu.paymentservice.model.PaymentType;
import cs.mum.edu.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${bankaccountsvc:localhost:8001}")
    private String nextBankAccountService;
    @Value("${creditcardsvc:localhost:8002}")
    private String nextCreditCardService;
    @Value("${paypalsvc:localhost:8003}")
    private String nextPaypalService;

    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:vanapikey}")
    private String apiKey;

    @PostMapping("/{payment_type}")
    public @ResponseBody
    Long processPayment(@PathVariable("payment_type") String paymentType, @RequestBody PaymentDTO payment){
        String nextService;
        switch (PaymentType.valueOf(paymentType)){
            case BankAccount:
                nextService = nextBankAccountService;
                break;
            case CreditCard:
                nextService = nextCreditCardService;
                break;
            case Paypal:
                nextService = nextPaypalService;
                break;
            default: nextService = "";
        }
        final String uri = String.format("http://%s/process", nextService);
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("APIKey", apiKey);
            HttpEntity<PaymentDTO> entity = new HttpEntity<PaymentDTO>(payment, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Long> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Long.class);
//            result = restTemplate.getForObject(uri, Boolean.class);
//            restTemplate.postForObject(url, request, ResponseBean.class);

            if(result.getBody() == -1)
                return Long.valueOf(-1);

            Long transactionId = result.getBody();
            PaymentTransaction responsePayment = new PaymentTransaction();
//            responsePayment.setPaymentType(paymentType);
            responsePayment.setTotal(payment.getTotal());
            responsePayment.setTransactionId(transactionId);
            responsePayment = paymentService.createPayment(responsePayment);
            return responsePayment.getId();
        }
        catch (Exception e){
            e.printStackTrace();
            return Long.valueOf(-1);
        }

    }
}
