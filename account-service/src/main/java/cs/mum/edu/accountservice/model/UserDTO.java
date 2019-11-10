package cs.mum.edu.accountservice.model;


import cs.mum.edu.accountservice.entities.Address;
import cs.mum.edu.accountservice.entities.BankAccount;
import cs.mum.edu.accountservice.entities.CreditCard;
import cs.mum.edu.accountservice.entities.Paypal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private Address address;
    private CreditCard credit;
    private BankAccount bank;
    private Paypal paypal;
}