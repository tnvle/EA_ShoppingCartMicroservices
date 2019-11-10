package cs.mum.edu.paymentservice.repository;

import cs.mum.edu.paymentservice.entities.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransaction, Integer> {
}
