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

import java.util.*;

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

    //when testing, why is transactions returning a balance field?
    public Transactions newTransaction(long id, Transactions transactions){
        Account account = accountRepo.findById(id).get();
        transactions.setAccount(account);
        return transactionRepo.save(transactions);
    }

       /** get all transactions*/
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionList = transactionRepo.findAll();
        return transactionList;
    }
    public List<Transactions> getTransactionsByAccountId(long id){
            List<Transactions> transactions = new ArrayList<>();
            Users users = ur.findById(id).get();
            transactions.addAll(users.getTransactions());
            return transactions;
        }



    }


