package cs.mum.edu.paymentservice.controller;

import cs.mum.edu.paymentservice.entities.Payment;
import cs.mum.edu.paymentservice.model.PaymentDTO;
import cs.mum.edu.paymentservice.repository.PaymentRepository;
import cs.mum.edu.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/{payment_type}")
    public @ResponseBody
    PaymentDTO processPayment(@PathVariable("payment_type") String paymentType, @RequestBody PaymentDTO payment){

        return paymentService.createPayment(payment);
    }
}
