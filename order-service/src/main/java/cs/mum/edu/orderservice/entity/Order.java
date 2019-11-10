package cs.mum.edu.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

}

