package cs.mum.edu.orderservice.service;

import cs.mum.edu.orderservice.entity.Order;

public interface OrderService {
    public Order getById(Long id);

    public Order processOrder(Order order);
}
