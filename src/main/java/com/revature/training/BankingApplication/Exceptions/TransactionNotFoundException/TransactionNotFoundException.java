package com.revature.training.BankingApplication.Exceptions.TransactionNotFoundException;

public class TransactionNotFoundException extends Throwable {
    public TransactionNotFoundException(String s) {
        super("Transaction ot found");

    }
}
