package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.BankingApplication;
import com.revature.training.BankingApplication.Exceptions.UnauthorizedUserEcception;
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
    public UserService(UserRepo userRepo, AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        BankingApplication.log.info("User Account");
    }


    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    // adding the token to the adding users (registering)
    public Users addUsers(Users user) {
        long token = (long) (Math.random() * Long.MAX_VALUE);
        user.setSecureToken(token);
        return userRepo.save(user);
    }

    public Users getUserById(long id) {
        Optional<Users> userOption = userRepo.findById(id);
        Users users = userOption.get();
        BankingApplication.log.info("Getting a specific user by id: " + users);
        return users;
    }

    /**
     * changed the getByReferenceID to findById with the get() at the end to handle
     * the optional type
     */
    public Optional<List<Account>> getUserAccount(long id) {
        //List<Account> accounts = accountRepo.findAllById(Collections.singleton(id));
        Optional<List<Account>> accounts = accountRepo.findAccountById(id);
        BankingApplication.log.info("Account entity associated with certain user_id: " + id + accounts);
        return accounts;
    }

    /**
     * this section is for logging in.
     */
    public Users login(Users users) throws UnauthorizedUserEcception {
        Users userActual = userRepo.findUserByusername(users.getUsername());
        if (userActual.getPassword().equals(users.getPassword())) {
            long token = (long) (Math.random() * Long.MAX_VALUE);
            userActual.setSecureToken(token);
            userRepo.save(userActual);
            return userActual;
        } else {
            throw new UnauthorizedUserEcception();
        }
    }

}
