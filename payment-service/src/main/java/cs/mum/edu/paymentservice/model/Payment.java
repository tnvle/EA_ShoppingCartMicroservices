package cs.mum.edu.paymentservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal total;

    private Boolean successStatus;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
