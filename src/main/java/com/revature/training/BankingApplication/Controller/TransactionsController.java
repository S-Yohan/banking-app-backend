package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Service.AccountService;
import com.revature.training.BankingApplication.Service.TransactionService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class TransactionsController {


    TransactionService transactionService;

    @Autowired
    public void TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /*Posts transactions under a specific account id*/
    @PostMapping("accounts/{id}/transactions")
    public Transactions postTransaction(@PathVariable("id") Long id, @RequestBody Transactions transactions) {
        return transactionService.depositTransaction(id, transactions);
    }

    /*Get all transactions in the database we will never need to use this*/
    @GetMapping("transactions")
    public List<Transactions> getAllTransactions() {
        return transactionService.getAllTransactions();
    }



    //since we have added the accountId field in the model, this should pull all transactions for a specific account.
    @GetMapping("accounts/{accountId}/transactions")
    public List<Transactions> getTransactionsByPostTo(@PathVariable("accountId") int accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
    // this endpoint actually is retrieving the transactions by transaction ID
  /*  @GetMapping("transactions/{id}")
    public List<Transactions> getAllTransactionsByAccount(@PathVariable long id) {
        return transactionService.getTransactionsByAccountId(id);
    }*/
}

