package cs.mum.edu.bankaccountpaymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount implements Payment {
    private String account;
    private String type = BankAccount.class.toString();
}


