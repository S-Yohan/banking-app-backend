package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Query("FROM Account WHERE id = :id")
    Account findAccountByUserId(@Param("id")long id);

}
