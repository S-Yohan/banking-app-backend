package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Service.AccountService;
import com.revature.training.BankingApplication.Service.TransactionService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin (origins = {"http://localhost:4200"}, allowCredentials = "true")
public class TransactionsController {


    TransactionService transactionService;
    AccountService as;

    @Autowired
    public void TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**Posts transactions under a specific account*/
    @PostMapping("accounts/{id}/{type}")
    public Transactions postTransaction(@PathVariable("id") Long id,
                                        @PathVariable ("type") String type,
                                        @RequestBody Transactions transaction) {
        return transactionService.newTransaction(id, transaction);
    }

    /**This endpoint should return all transactions under a specific account id. The parameter given however
     * is a user_id. Get the account under this user_id then get the transactions under the account.
     * */
    @GetMapping("accounts/{id}/transactions")
    public List<Transactions> getTransactionsByPostTo(@PathVariable("id") int id) {
          return transactionService.getTransactionsByAccountId(id);
    }

}

