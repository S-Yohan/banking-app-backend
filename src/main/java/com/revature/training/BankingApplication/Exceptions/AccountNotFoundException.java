package com.revature.training.BankingApplication.Exceptions;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String s){
        super("This user's account is not found");
    }

}
