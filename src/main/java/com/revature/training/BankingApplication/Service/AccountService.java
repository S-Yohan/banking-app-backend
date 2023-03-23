package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepo accountRepo;
    @Autowired
    public AccountService(AccountRepo savingsRepo) {
        this.accountRepo = savingsRepo;
    }

    //User should be able to open(add)a savings account.
    //need to figure out how to auto generate a savings acct#
    public Account addAccount(Account account){
        int min = 0;
        int max = 0;
        if(account.getAccountType().equals("savings")) {
            min = 20000;
            max = 20000000;
        }else {
            min = 10000;
            max = 10000000;
        }
        int accountNum = (int) (Math.random() * ((max - min) + 1));
        account.setAccountNumber(accountNum);
        return accountRepo.save(account);
    }
    // User should be able to get all their accounts via
    public Account getAccountById(int id){
        Optional<Account> accountsOptional = accountRepo.findById(id);
        Account accounts = accountsOptional.get();
        return accounts;
    }
    //bank admin should be able to pull a list of all savings accounts
    public List<Account> getAllAccounts(){
        return accountRepo.findAll();
    }
    //User or admin should be able to delete an account if it has
    //been closed
    //this should be done via user_id
    //need to get a merge done to bring in the remaining info needed
    public Account deleteAccountById(int id){
        Optional<Account> accountOptional = accountRepo.findById(id);
        Account account = accountOptional.get();
        accountRepo.delete(account);
        return account;
    }


}
