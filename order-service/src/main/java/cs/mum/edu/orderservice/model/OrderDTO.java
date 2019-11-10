package cs.mum.edu.orderservice.model;

import cs.mum.edu.orderservice.entity.Address;
import cs.mum.edu.orderservice.entity.OrderItem;
import cs.mum.edu.orderservice.entity.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String customerEmail;

    private Address address;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Payment payment;

    private List<OrderItem> items;

    private double total;
}
