package cs.mum.edu.creditcardpaymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements Payment {
    private String cardname;
    private String cardnumber;

    private String type = CreditCard.class.toString();
}


