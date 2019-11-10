package cs.mum.edu.paymentservice.controller;

import cs.mum.edu.paymentservice.model.Payment;
import cs.mum.edu.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public @ResponseBody
    Payment processPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }
}
