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
    public Transactions newTransaction(long id, Transactions transaction){
        Account account = accountRepo.getReferenceById(id);
        List<Transactions> accountTransactions = account.getTransactions();
        accountTransactions.add(transaction);
        return transaction;

    }

       /** get all transactions*/
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionList = transactionRepo.findAll();
        return transactionList;
    }


    public List<Transactions> getTransactionsByAccountId(long id){
        Account transactionAccount = accountRepo.findById(id).get();
        return transactionAccount.getTransactions();

    }
 }

