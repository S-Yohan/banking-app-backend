package com.revature.training.BankingApplication.Repository;

import com.revature.training.BankingApplication.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {

    /**Retrieve account entity(s) with balance field matching the balance parameter
     * using a JPQL query
//     */
//    @Query("FROM Account WHERE balance = : balance")
//    List<Account>findAccountBalance(Double balance);
}
