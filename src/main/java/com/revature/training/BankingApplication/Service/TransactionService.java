package com.revature.training.BankingApplication.Service;

import com.revature.training.BankingApplication.Repository.TransactionRepo;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;
    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    //method to add a new transaction
    public Transaction depositTransaction(Transaction transaction){
        return null;
    }

    public Transaction withdrawalTransaction(Transaction transaction){ return null;}
    // get all transactions
    public List<Transaction> getAllTransactions(){
        return null;
    }
    // User should be able to pull transactions
    //For the website should be able to pull top 5
    //and then pull all if user clicks on "see all"
    // need to get the correct param to pass in
    public List<Transaction> getTransactionsByPostedTo(int post_to ){
        return null;
    }
}
