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
    public AccountService(AccountRepo accountRepo, UserRepo userRepo){
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    /**This method gets all account details using the findAll method provided by Spring
     * Data JPARepositories*/
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    /**This is a persistent account entity, the save method which is provided
     * by Spring Data JPARepositories is used to persist the account*/
    public Account addAccount(Account account) {
        BankingApplication.log.info("Account method execution: AccountService.saveAccount");
        return accountRepo.save(account);
    }

    /**return an account of a specific Id from the AccountRepo*/
    public Account getAccountById(long id){
        Optional<Account>accountId = accountRepo.findById(id);
        Account account= accountId.get();
        BankingApplication.log.info("account by specific id "+ id + ", " + account);
        return accountId.get();
    }


    /**return the account entity associated with a certain user*/
    public Users getAccountByUser(long id){
        Account userAccount = getAccountById(id);
        Users user = userAccount.getUsers();
        BankingApplication.log.info("Account entity associated with certain user: " + id + "," + user);
        return user;   //return an account object
    }

    /**The delete method removes account entity*/
    public Account deleteAccounts(Long id) {
        Optional<Account> deleteOption = accountRepo.findById(id);
        Account account = deleteOption.get();
        accountRepo.delete(account);
        BankingApplication.log.info("Account with Account_id "+id+ " deleted");
        return account;
    }

//    public List<Account> getUserBalance(double balance) {
//        return accountRepo.findAccountBalance(balance);
//    }

//    public Account addAccount(Account account){
//        long min = 10000;
//        long max = 10000000;
//
//        long accountNum = (int) (Math.random() * ((max - min) + 1));
//        account.setAccountNo(accountNum);
//        return accountRepo.save(account);
//    }
}
