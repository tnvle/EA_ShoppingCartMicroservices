package cs.mum.edu.orderservice.controller;

import cs.mum.edu.orderservice.entity.Address;
import cs.mum.edu.orderservice.entity.Order;
import cs.mum.edu.orderservice.entity.OrderItem;
import cs.mum.edu.orderservice.entity.OrderStatusType;
import cs.mum.edu.orderservice.model.OrderDTO;
import cs.mum.edu.orderservice.model.PaymentDTO;
import cs.mum.edu.orderservice.model.ShippingDTO;
import cs.mum.edu.orderservice.model.ShippingItem;
import cs.mum.edu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Value("${AUTHENTICATE_SERVICE:localhost:8888}")
    private String authenticateService;

    @Value("${PAYMENT_SERVICE:localhost:8885}")
    private String paymentService;

    @Value("${SHIPPING_SERVICE:localhost:8086}")
    private String shippingService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO, @RequestHeader(name="Authorization", required = false) String token) {

        final String authenticateURI = String.format("http://%s/validatetoken", authenticateService);
        final String paymentURI = String.format("http://%s/api/payment/%s", paymentService, orderDTO.getPaymentType().toString());
        final String shippingURI = String.format("http://%s/api/shipping", shippingService);

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
            HttpHeaders paymentHeaders = new HttpHeaders();
//            headers.set("Authorization", token);
            HttpEntity<PaymentDTO> paymentEntity  = new HttpEntity<PaymentDTO>(paymentDTO, paymentHeaders);

            RestTemplate paymentRestTemplate = new RestTemplate();
            ResponseEntity<Long> paymentId = paymentRestTemplate.exchange(paymentURI, HttpMethod.POST, paymentEntity, Long.class);

            if(paymentId.getBody() == -1)
                return ResponseEntity.ok("Cannot process transaction!!!");

            //save Order
            Order order = new Order();
            order.setCustomerEmail(orderDTO.getCustomerEmail());
            order.setAddress(orderDTO.getAddress());
            order.setStatus(OrderStatusType.Shipped);
            order.setItems(orderDTO.getItems());
            order.setPaymentId(paymentId.getBody());
            order.setPaymentType(orderDTO.getPaymentType());
            orderService.save(order);

            //shipping
            ShippingDTO shippingDTO = new ShippingDTO();
            shippingDTO.setOrderId(order.getId());

            Address address = new Address();
            address.setCity(order.getAddress().getCity());
            address.setState(order.getAddress().getState());
            address.setStreet(order.getAddress().getStreet());
            address.setZipcode(order.getAddress().getZipcode());
            shippingDTO.setAddress(address);

            List<ShippingItem> shippingItems = new ArrayList<>();
            for(OrderItem orderItem:order.getItems()){
                ShippingItem shippingItem = new ShippingItem();
                shippingItem.setProductId(orderItem.getProductId());
                shippingItem.setProductPrice(orderItem.getProductPrice());
                shippingItem.setQuantity(orderItem.getQuantity());
                shippingItems.add(shippingItem);
            }
            shippingDTO.setItemList(shippingItems);

            HttpHeaders shippingHeaders = new HttpHeaders();
//            headers.set("Authorization", token);
            HttpEntity<ShippingDTO> shippingEntity  = new HttpEntity<ShippingDTO>(shippingDTO, shippingHeaders);

            RestTemplate shippingRestTemplate = new RestTemplate();
            ResponseEntity<Long> shippingId = shippingRestTemplate.exchange(shippingURI, HttpMethod.POST, shippingEntity, Long.class);

            if(shippingId.getBody() == -1)
                return ResponseEntity.ok("Cannot process shipping!!!");

            return ResponseEntity.ok(order);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/{id}")
    public @ResponseBody Order findOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
