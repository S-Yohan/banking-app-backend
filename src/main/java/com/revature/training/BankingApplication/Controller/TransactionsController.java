package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Transactions;
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
    public Transactions postDeposit(@RequestBody Transactions transaction){
        return transactionService.depositTransaction(transaction);
    }

    @PostMapping("transactions")
    public Transactions postWithdrawal(@RequestBody Transactions transaction){
        return transactionService.withdrawalTransaction(transaction);
    }

    @GetMapping("transactions")
    public List<Transactions> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("transaction/{posted_to}")
    public List<Transactions> getTransactionsByPostTo(@PathVariable int posted_to){
        return transactionService.getTransactionsByPostedTo(posted_to);
    }
}
