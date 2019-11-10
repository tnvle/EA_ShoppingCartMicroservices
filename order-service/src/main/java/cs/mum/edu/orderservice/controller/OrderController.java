package cs.mum.edu.orderservice.controller;

import cs.mum.edu.orderservice.entity.Order;
import cs.mum.edu.orderservice.model.OrderDTO;
import cs.mum.edu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Value("${AUTHENTICATE_SERVICE:localhost:8888}")
    private String authenticateService;

    @Value("${PAYMENT_SERVICE:localhost:8889}")
    private String paymentService;

    @PostMapping
    public @ResponseBody
    Order createOrder(@RequestBody OrderDTO order, @RequestHeader(name="Authorization", required = false) String token) {

        final String authenticateURI = String.format("http://%s/validatetoken", authenticateService);
        final String paymentURI = String.format("http://%s/validatetoken", paymentService);

        try{
            //call authenticate service
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Boolean> result =
                    restTemplate.exchange(authenticateURI, HttpMethod.GET, entity, Boolean.class);
//            result = restTemplate.getForObject(uri, Boolean.class);
//            restTemplate.postForObject(url, request, ResponseBean.class);

            //call payment service
            headers = new HttpHeaders();
//            headers.set("Authorization", token);
            entity = new HttpEntity<String>("parameters", headers);

            restTemplate = new RestTemplate();
            ResponseEntity<Long> paymentId =
                    restTemplate.exchange(paymentURI, HttpMethod.POST, entity, Long.class);


            return ResponseEntity.ok(userInfo);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("Unauthorized");
        }
        return orderService.processOrder(order);
    }

    @GetMapping("/{id}")
    public @ResponseBody Order findOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
