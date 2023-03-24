package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {
}
