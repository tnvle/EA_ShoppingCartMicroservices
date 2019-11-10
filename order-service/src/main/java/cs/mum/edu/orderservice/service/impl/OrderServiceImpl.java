package cs.mum.edu.orderservice.service.impl;

import cs.mum.edu.orderservice.entity.Order;
import cs.mum.edu.orderservice.repository.OrderRepository;
import cs.mum.edu.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order processOrder(Order order) {
        return orderRepository.save(order);
    }
}
