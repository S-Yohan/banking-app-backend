package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Exceptions.AccountNotFoundException;
import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import com.revature.training.BankingApplication.Repository.TransactionRepo;
import com.revature.training.BankingApplication.Repository.UserRepo;
import com.revature.training.BankingApplication.Exceptions.TransactionNotFoundException.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

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


   // Users should be able to post a deposit or a bill pay transaction

    public Transactions newTransaction(Long id, Transactions transaction) throws AccountNotFoundException {
        double newBalance = 0;
        Transactions addTransaction = transactionRepo.save(transaction);// adds new transaction
        Account account = accountRepo.findAccountByUserId(id);//retrieve the user account
        account.getTransactions().add(addTransaction);//update the transactions
        if(transaction.getTranstype().equalsIgnoreCase("deposit")){
            newBalance = account.getBalance() + addTransaction.getTransamount();
        }else if(transaction.getTranstype().equalsIgnoreCase("bill pay")){
            newBalance = account.getBalance() - addTransaction.getTransamount();
        }
        account.setBalance(newBalance);//update deposit
        accountRepo.save(account);

        return addTransaction;
    }
    public List<Transactions> getTransactionsByUserId(long id) throws TransactionNotFoundException {
        Account user_account = accountRepo.findAccountByUserId(id);
        return user_account.getTransactions();
    }

    @ExceptionHandler({TransactionNotFoundException.class})
    public ResponseEntity<String> invalidTransactionRequest() {
        ResponseEntity<String> res = new ResponseEntity<>("No transactions under this account", HttpStatus.NOT_FOUND);
        return res;

    }

    @ExceptionHandler({AccountNotFoundException.class})
    public ResponseEntity<String> invalidAccountRequest() {
        ResponseEntity<String> res = new ResponseEntity<>("No accounts by this user", HttpStatus.NOT_FOUND);
        return res;
    }
}


