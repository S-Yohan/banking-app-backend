package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
