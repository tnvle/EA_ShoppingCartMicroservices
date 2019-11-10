package cs.mum.edu.accountservice.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardname;
    private String cardnumber;
    private String cvv;
    private String expiration;
    private Boolean preferred;
}