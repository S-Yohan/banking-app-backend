package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    //Post request to create a new savings account
    @PostMapping("accounts")
    public Account postAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    // consider this being pulling from user_id
    @GetMapping("accounts/{account_id}")
    public Account getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @GetMapping("accounts")
    public List<Account> getAllAccounts() throws Exception{
        return accountService.getAllAccounts();
    }

    @DeleteMapping("accounts/{account_id}")
    public Account deleteAccount(@PathVariable int id){
        return accountService.deleteAccountById(id);
    }

}
