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

    //testing method for adding a transaction.
   /* public Transactions addTransaction(Transactions transaction){
        return transactionRepo.save(transaction);
    }*/
    //method to add a new transaction
  public Transactions depositTransaction(Transactions transaction){
        Account account = accountRepo.getReferenceById((long) transaction.getPosted_to());
        double depositAmount = transaction.getDeposit_amount();
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + depositAmount;
        account.setBalance(newBalance);
        return transactionRepo.save(transaction);
    }

  public Transactions withdrawalTransaction(Transactions transaction){
        Account account = accountRepo.getReferenceById((long) transaction.getPosted_to());
        double withdrawalAmount = transaction.getWithdrawal_amount();
        double currentBalance = account.getBalance();
        double newBalance = currentBalance - withdrawalAmount;
        account.setBalance(newBalance);
        return transactionRepo.save(transaction);
    }
    // get all transactions
    public List<Transactions> getAllTransactions(){
        List<Transactions> transactionList = transactionRepo.findAll();
        return transactionList;
    }
    // User should be able to pull transactions
    //For the website should be able to pull top 5
    //and then pull all if user clicks on "see all"
    // need to get the correct param to pass in
    public List<Transactions> getTransactionsByPostedTo(int posted_to ){

        return transactionRepo.findAllById(Collections.singleton((long) posted_to));
    }
}
