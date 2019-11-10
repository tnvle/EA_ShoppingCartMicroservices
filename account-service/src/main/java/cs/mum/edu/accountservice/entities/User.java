package cs.mum.edu.accountservice.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard credit;
    @OneToOne(cascade = CascadeType.ALL)
    private BankAccount bank;
    @OneToOne(cascade = CascadeType.ALL)
    private Paypal paypal;

}
