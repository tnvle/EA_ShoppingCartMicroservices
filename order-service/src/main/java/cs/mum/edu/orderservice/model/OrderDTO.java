package cs.mum.edu.orderservice.model;

import cs.mum.edu.orderservice.entity.Address;
import cs.mum.edu.orderservice.entity.OrderItem;
import cs.mum.edu.orderservice.entity.OrderStatusType;

import javax.persistence.*;
import java.util.List;

public class OrderDTO {

    private String customerEmail;

    private Address address;

    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

    private List<OrderItem> items;
}
