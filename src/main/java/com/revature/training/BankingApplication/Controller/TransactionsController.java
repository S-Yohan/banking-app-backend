package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Exceptions.AccountNotFoundException;
import com.revature.training.BankingApplication.Model.Transactions;
import com.revature.training.BankingApplication.Repository.TransactionRepo;
import com.revature.training.BankingApplication.Service.AccountService;
import com.revature.training.BankingApplication.Exceptions.TransactionNotFoundException.TransactionNotFoundException;
import com.revature.training.BankingApplication.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST} )
public class TransactionsController {


    TransactionService transactionService;
    AccountService as;
    TransactionRepo transRepo;

    @Autowired
    public void TransactionController(TransactionService transactionService, AccountService as,
                                      TransactionRepo transRepo) {
        this.transactionService = transactionService;
        this.transRepo = transRepo;
        this.as = as;
    }

    /**Posts transactions under a specific account*/

    @PostMapping("account/{id}/{type}")
    public Transactions postTransaction(@PathVariable("id") Long id,
                                        @PathVariable ("type") String type,
                                        @RequestBody Transactions transaction) throws AccountNotFoundException {

        return transactionService.newTransaction(id, transaction);
    }

    /**This endpoint should return all transactions under a specific account id. The parameter given however
     * is a user_id. Get the account under this user_id then get the transactions under the account.
     * */
    @CrossOrigin (origins = "http://localhost:4200" )
    @GetMapping("account/{id}/transactions")
    public Object [] getTransactionsByUser (@PathVariable("id") int id) throws TransactionNotFoundException {
        Object[] output = (transactionService.getTransactionsByUserId(id)).toArray();
        return output;

    }

}

