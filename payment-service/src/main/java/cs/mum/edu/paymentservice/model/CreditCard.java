package cs.mum.edu.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements Payment {
    private String cardname;
    private String cardnumber;
    private String cvv;
    private String expiration;
}
