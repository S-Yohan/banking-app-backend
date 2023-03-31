package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.BankingApplication;
import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import com.revature.training.BankingApplication.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    AccountRepo accountRepo;
    UserRepo userRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }


    /**
     * This is a persistent account entity, the save method which is provided
     * by Spring Data JPARepositories is used to persist the account
     */
    public Account addAccount(long userId, Account account) {

        long min = 10000;
        long max = 10000000;
        long accountNum = (int) (Math.random() * ((max - min) + 1));
        account.setAccountNumber(accountNum);
        BankingApplication.log.info("Account method execution: AccountService.saveAccount");
        return accountRepo.save(account);
    }


    /**
     * Given a user_id this method returns a specific account from the  AccountRepo
     */
    public Account getAccountById(long id) {
        Account user_account = accountRepo.findById(id).get();
        return user_account;
    }
    /**
     * */
    public Account addNewBalance (Double balance, long id){
        Account new_balance_account = getAccountById(id);
        new_balance_account.setBalance(balance);
        return new_balance_account;
    }


}
