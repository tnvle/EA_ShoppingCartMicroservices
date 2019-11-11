package cs.mum.edu.paypalpaymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paypal implements Payment {
    private String account;

    private String type = Paypal.class.toString();
}