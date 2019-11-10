package cs.mum.edu.bankaccoundpaymentservice.repository;

import cs.mum.edu.bankaccoundpaymentservice.entities.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
}
