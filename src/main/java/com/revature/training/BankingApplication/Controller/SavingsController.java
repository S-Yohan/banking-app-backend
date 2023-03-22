package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Model.Savings;
import com.revature.training.BankingApplication.Service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SavingsController {
    SavingService savingService;

    @Autowired
    public void SavingsColloer(SavingService savingService){
        this.savingService = savingService;
    }

    //Post request to create a new savings account
    @PostMapping("savings")
    public Savings postSavings(@RequestBody Savings savings){
        return savingService.addSavings(savings);
    }

    // consider this being pulling from user_id
    @GetMapping("savings/{savings_id}")
    public Savings getSavingsById(@PathVariable int id){
        return savingService.getSavingsById(id);
    }

    @GetMapping("savings")
    public List<Savings> getAllSavings() throws Exception{
        return savingService.getAllSavings();
    }

    @DeleteMapping("savings/{savings_id}")
    public Savings deleteSavings(@PathVariable int id){
        return savingService.deleteAccountById(id);
    }

}
