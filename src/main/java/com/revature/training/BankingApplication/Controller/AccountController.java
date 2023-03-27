package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
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

    /** users should be able to make a get request and receive a JSON
     * response containing all account, GET localhost:9000/accounts should respond with
     * [
     *      "account number":"293849"
     *      "account owner":"jane"
     *      "account type":"checking"
     *      "balance":"300"
     * ]**/

    @GetMapping("accounts")
    public List<Account>getAllAccount()throws Exception{
        return accountService.getAllAccounts();
    }

    /**User should be able to view their account using their user_id
     *GET localhost:9000/user/{user_id}/account **/
    @GetMapping("account/{account_id}/users")
    public Users getAccountByUser(@PathVariable long id) throws Exception{
        return accountService.getAccountByUser(id);
    }

    /**User should be able to get account by account Id using the
     * GET localhost:9000/account/{id}*/
    @GetMapping("accounts/{id}")
    public Account getAccountById(@PathVariable("id") long id){
        return accountService.getAccountById(id);
    }

    /**user should be able to get the balance from one of their accounts
     * either a checking or savings account.
     *  using Get localhost:9000/account?accountType=checking&balance=200*/
//    @GetMapping(value = "account", params = {"accountType","balance"})
//    public List<Account>getUserBalance(@PathVariable double balance){
//        return accountService.getUserBalance(balance);
//    }

    /**Users should be able to make a post request using  POST localhost:9000/accounts
     * a**/
    @PostMapping("accounts")
    public Account postAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @DeleteMapping("accounts/{id}")
    public Account deleteAccount(@PathVariable("id") long id)throws Exception{
        return accountService.deleteAccounts(id);
    }
}
