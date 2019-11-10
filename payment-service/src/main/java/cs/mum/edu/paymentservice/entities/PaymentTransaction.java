package cs.mum.edu.paymentservice.entities;

import cs.mum.edu.paymentservice.model.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Long transactionId;
}
