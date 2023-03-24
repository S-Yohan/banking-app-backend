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
    AccountService accountService;

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
    //for testing purposes
  /*  @PostMapping("transactions")
    public Transactions addTransaction(@RequestBody Transactions transactions){
        return this.transactionService.addTransaction(transactions);
    }*/
    @GetMapping("transactions")
    public List<Transactions> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("transactions/{posted_to}")
    public List<Transactions> getTransactionsByPostTo(@PathVariable int posted_to){
        return transactionService.getTransactionsByPostedTo(posted_to);
    }
}
