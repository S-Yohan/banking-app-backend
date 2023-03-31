package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import com.revature.training.BankingApplication.Repository.TransactionRepo;
import com.revature.training.BankingApplication.Repository.UserRepo;
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

    UserRepo ur;


    @Autowired
    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo,
                              UserRepo ur) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
        this.ur = ur;
    }
    public Transactions newTransaction(long id, Transactions transaction){

        Optional<Account> account = accountRepo.findById(id);
        List<Transactions> accountTransactions = account.get().getTransactions();
        accountTransactions.add(transaction);
        return transaction;

    }

       /** get all transactions*/
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionList = transactionRepo.findAll();
        return transactionList;
    }


    public List<Transactions> getTransactionsById(long id){
        List<Transactions> transactions = this.transactionRepo.findByUsers(id);
        return transactions;

    }
 }

