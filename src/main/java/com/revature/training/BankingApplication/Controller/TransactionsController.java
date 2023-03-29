package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Service.AccountService;
import com.revature.training.BankingApplication.Service.TransactionService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TransactionsController {


    TransactionService transactionService;
    @Autowired
    public void TransactionController(TransactionService transactionService) {
         this.transactionService = transactionService;}

    /*Posts transactions under a specific account id*/
    @PostMapping("accounts/{id}/transactions")
    public Transactions postTransaction(@PathVariable ("id") Long id, @RequestBody Transactions transactions){
        return transactionService.depositTransaction(id, transactions);
    }
    /*Get all transactions in the database we will never need to use this*/
    @GetMapping("transactions")
    public List<Transactions> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("transactions/{id}")
    public List<Transactions> getAllTransactionsByAccount(@PathVariable long id){
        return transactionService.getTransactionsByAccount(id);
    }
}
