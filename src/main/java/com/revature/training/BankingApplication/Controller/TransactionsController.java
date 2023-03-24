package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Service.TransactionService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TransactionsController {
    TransactionService transactionService;
    @Autowired
    public void TransactionController(TransactionService transactionService) { this.transactionService = transactionService;}

    @PostMapping("transactions")
    public Transaction postDeposit(@RequestBody Transaction transaction){
        return transactionService.depositTransaction(transaction);
    }

    @PostMapping("transactions")
    public Transaction postWithdrawal(@RequestBody Transaction transaction){
        return transactionService.withdrawalTransaction(transaction);
    }

    @GetMapping("transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("transaction/{posted_to}")
    public List<Transaction> getTransactionsByPostTo(@PathVariable int posted_to){
        return transactionService.getTransactionsByPostedTo(posted_to);
    }
}
