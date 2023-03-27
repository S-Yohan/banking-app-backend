package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.BankingApplication;
import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Repository.AccountRepo;
import com.revature.training.BankingApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepo userRepo;
    AccountRepo accountRepo;
    @Autowired
    public UserService(UserRepo userRepo, AccountRepo accountRepo){
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        BankingApplication.log.info("User Account");
    }


/*   public User registerUser(User user) {
//        return userRepo.save(user);
//    }
//
//    public User userLogin(User user) {
//        return userRepo.save(user);
//    }
*/

    /** User can decide to close an account, this is a delete method to delete user account*/
    public Users deleteUser(long id) {
        Optional<Users> optionalUser = userRepo.findById(id);
        Users user  = optionalUser.get();
        userRepo.delete(user);
        BankingApplication.log.info("Deleted UserAccount of Id: "+ id + " which was " + user);
        return user;
    }
//
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }
//
    public Users addUsers(Users user) {
        return userRepo.save(user);
    }

    public Users getUserById(long id) {
        Optional<Users>userOption = userRepo.findById(id);
        Users users = userOption.get();
        BankingApplication.log.info("Getting a specific user by id: "+ users);
        return users;
    }

    public Account getUserAccount(long id) {
        // this top statement may not be needed. You might be able to just pass the id param into the Account account line
        Users userAccount = getUserById(id);
        //Account account = userAccount.getAccount();
        Account account = accountRepo.getReferenceById(userAccount.getUserId());
        BankingApplication.log.info("Account entity associated with certain user_id: " + id + account);
        return account;
    }
}

/*public Account addAccount(Account account){
        int min = 0;
        int max = 0;
        if(account.getAccountType().equals("savings")) {
            min = 20000;
            max = 20000000;
        }else {
            min = 10000;
            max = 10000000;
        }
        int accountNum = (int) (Math.random() * ((max - min) + 1));
        account.setAccountNumber(accountNum);
        return accountRepo.save(account);
    }*/