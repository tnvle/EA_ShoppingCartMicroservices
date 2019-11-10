package cs.mum.edu.orderservice.controller;

import cs.mum.edu.orderservice.model.Order;
import cs.mum.edu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping
    public @ResponseBody
    Order createOrder(@RequestBody Order order) {
        return orderService.processOrder(order);
    }

    @GetMapping("/{id}")
    public @ResponseBody Order findOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
