package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Service.AccountService;
import com.revature.training.BankingApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class AccountController {
    AccountService accountService;
    UserService us;

    @Autowired
    public AccountController(AccountService accountService, UserService us) {
        this.accountService = accountService;
        this.us = us;


    }


    /**
     * User should be able to deposit funds to their account using their user_id
     * GET localhost:9000/account/{user_id}/deposit
     **/

    @PostMapping("account/{id}/deposit")
    public Account updateBalance(@PathVariable long id, @RequestBody Account account) {
        Double balance = account.getBalance();
        return this.accountService.addNewBalance(balance, id);

    }

    /**
     * Given a specific user_id the account under this user should be obtained from the repository
     * GET localhost:9000/account/{id}
     */
    @GetMapping("account/{id}")
    public Optional<List<Account>> getAccountById(@PathVariable("id") long id) {
        Users user = us.getUserById(id);
        Optional<List<Account>> accounts = us.getUserAccount(id);
        return accounts;
    }

    /**
     * Users should be able to make a post request using  POST localhost:9000/account/{id}
     * This endpoint should create a new account.
     */

    @PostMapping("open-account/{id}")
    public Account postAccount(@PathVariable("id") long id, @RequestBody Account account) {
        return accountService.addAccount(id, account);
    }


}
