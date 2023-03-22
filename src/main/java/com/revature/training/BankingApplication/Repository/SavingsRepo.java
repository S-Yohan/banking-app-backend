package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepo extends JpaRepository<Savings, Integer> {
}
