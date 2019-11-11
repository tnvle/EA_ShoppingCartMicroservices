package cs.mum.edu.creditcardpaymentservice.repository;


import cs.mum.edu.creditcardpaymentservice.entities.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Long> {
}
