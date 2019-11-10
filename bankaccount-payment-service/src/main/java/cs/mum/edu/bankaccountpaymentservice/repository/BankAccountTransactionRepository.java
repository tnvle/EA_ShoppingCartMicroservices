package cs.mum.edu.bankaccountpaymentservice.repository;

import cs.mum.edu.bankaccountpaymentservice.entities.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
}
