package cs.mum.edu.paymentservice.repository;

import cs.mum.edu.paymentservice.model.Paypal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalRepository extends JpaRepository<Paypal, Integer> {
}
