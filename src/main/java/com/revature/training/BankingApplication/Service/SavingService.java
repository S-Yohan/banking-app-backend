package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Model.Savings;
import com.revature.training.BankingApplication.Repository.SavingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingService {
    private final SavingsRepo savingsRepo;
    @Autowired
    public SavingService(SavingsRepo savingsRepo) {
        this.savingsRepo = savingsRepo;
    }

    //User should be able to open(add)a savings account.
    //need to figure out how to auto generate a savings acct#
    public Savings addSavings(Savings savings){
        int min = 20000;
        int max = 20000000;
        int accountNum = (int)(Math.random() * ((max-min)+1));
        savings.setAccountNumber(accountNum);
        return savingsRepo.save(savings);
    }
    // User should be able to get all their savings accounts by their id
    public Savings getSavingsById(int id){
        Optional<Savings> savingsOptional = savingsRepo.findById(id);
        Savings savings = savingsOptional.get();
        return savings;
    }
    //bank admin should be able to pull a list of all savings accounts
    public List<Savings> getAllSavings(){
        return savingsRepo.findAll();
    }
    //User or admin should be able to delete an account if it has
    //been closed
    //this should be done via user_id
    //need to get a merge done to bring in the remaining info needed
    public Savings deleteAccountById(int id){
        Optional<Savings> savingsOptional = savingsRepo.findById(id);
        Savings savings = savingsOptional.get();
        savingsRepo.delete(savings);
        return savings;
    }


}
