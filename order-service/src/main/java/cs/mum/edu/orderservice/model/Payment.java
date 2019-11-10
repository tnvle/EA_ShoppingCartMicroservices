package cs.mum.edu.orderservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BankAccount.class, name = "BankAccount"),
        @JsonSubTypes.Type(value = CreditCard.class, name = "CreditCard"),
        @JsonSubTypes.Type(value = Paypal.class, name = "Paypal")
})
public interface Payment {

}
