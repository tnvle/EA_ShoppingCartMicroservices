package cs.mum.edu.orderservice.model;

import cs.mum.edu.orderservice.entity.Address;
import cs.mum.edu.orderservice.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDTO {

    private Long orderId;
    private Address address;

    private List<OrderItem> itemList;
}
