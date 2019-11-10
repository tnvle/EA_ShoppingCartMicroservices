package cs.mum.edu.orderservice.controller;

import cs.mum.edu.orderservice.entity.Order;
import cs.mum.edu.orderservice.entity.OrderStatusType;
import cs.mum.edu.orderservice.model.OrderDTO;
import cs.mum.edu.orderservice.model.PaymentDTO;
import cs.mum.edu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Value("${AUTHENTICATE_SERVICE:localhost:8888}")
    private String authenticateService;

    @Value("${PAYMENT_SERVICE:localhost:8885}")
    private String paymentService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<Long> createOrder(@RequestBody OrderDTO orderDTO, @RequestHeader(name="Authorization", required = false) String token) {

        final String authenticateURI = String.format("http://%s/validatetoken", authenticateService);
        final String paymentURI = String.format("http://%s/api/payment/%s", paymentService, orderDTO.getPaymentType().toString());

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
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPayment(orderDTO.getPayment());
            paymentDTO.setTotal(orderDTO.getTotal());
            headers = new HttpHeaders();
//            headers.set("Authorization", token);
            HttpEntity<PaymentDTO> paymentEntity  = new HttpEntity<PaymentDTO>(paymentDTO, headers);

            restTemplate = new RestTemplate();
            ResponseEntity<Long> paymentId =
                    restTemplate.exchange(paymentURI, HttpMethod.POST, paymentEntity, Long.class);

            //shipping

            //save Order
            Order order = new Order();
            order.setCustomerEmail(orderDTO.getCustomerEmail());
            order.setAddress(orderDTO.getAddress());
            order.setStatus(OrderStatusType.Shipped);
            order.setItems(orderDTO.getItems());
            order.setPaymentId(paymentId.getBody());
            order.setPaymentType(orderDTO.getPaymentType());
            orderService.save(order);

            return ResponseEntity.ok(order.getId());
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Long.valueOf(-1));
        }

    }

    @GetMapping("/{id}")
    public @ResponseBody Order findOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
