package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {
    @Query("FROM Transactions WHERE accountId = :accountId")
    List<Transactions> findTransactionsByAccountId(@PathVariable("accountId") long accountId);
}
