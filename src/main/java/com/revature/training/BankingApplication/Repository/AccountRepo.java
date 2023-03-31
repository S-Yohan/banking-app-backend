package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<List<Account>> findAccountById(Long id);
}
