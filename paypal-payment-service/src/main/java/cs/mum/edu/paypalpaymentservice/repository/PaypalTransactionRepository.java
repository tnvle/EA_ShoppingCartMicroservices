package cs.mum.edu.paypalpaymentservice.repository;


import cs.mum.edu.paypalpaymentservice.entities.PaypalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalTransactionRepository extends JpaRepository<PaypalTransaction, Long> {
}
