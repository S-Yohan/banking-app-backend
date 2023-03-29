package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import com.revature.training.BankingApplication.Repository.TransactionRepo;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    AccountRepo accountRepo;
    //private AccountRepo accountRepo;
    TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public Transactions depositTransaction(Long accountId, Transactions transaction) {
        Account account = accountRepo.findById(accountId).get();
        Transactions t = transactionRepo.save(transaction);
        // t.setAccount(account); // sets the FKey
        double depositAmount = t.getDeposit_amount();
        transaction.setAccount(account);
        account.getTransactions().add(transaction);
        //double depositAmount = transaction.getDeposit_amount();
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + depositAmount;
        account.setBalance(newBalance);
        accountRepo.save(account);
        return t;
    }


    /* public Transactions withdrawalTransaction(Transactions transaction){
         Account account = accountRepo.getReferenceById((long) transaction.getPosted_to());
         double withdrawalAmount = transaction.getWithdrawal_amount();
         double currentBalance = account.getBalance();
         double newBalance = currentBalance - withdrawalAmount;
         account.setBalance(newBalance);
         return transactionRepo.save(transaction);
     }*/
    // get all transactions
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionList = transactionRepo.findAll();
        return transactionList;
    }

    // User should be able to pull transactions
    //For the website should be able to pull top 5
    //and then pull all if user clicks on "see all"


  /*  public List<Transactions> getTransactionsByAccountId(long accountId) {
        return transactionRepo.findById(accountId).get();
    }*/

    public List<Transactions> getTransactionsByAccountId(long id){
        Account transactionAccount = accountRepo.findById(id).get();
        return transactionAccount.getTransactions();
          //return transactionRepo.findAllById(Collections.singleton((long) id));
    }
 }

