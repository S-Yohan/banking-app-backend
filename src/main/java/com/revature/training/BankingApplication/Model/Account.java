package com.revature.training.BankingApplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "accounts")
public class Account {
   //creating the primary key, setting to auto generate, and not able to change to null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private String accountType;

    private int accountNumber;

    private double balance;


   // for this one, Accounts is the child (FKey) to Users
     @ManyToOne
     @JoinColumn(name = "UserId")
     private Users user;

     // here Accounts is the Parent and Transactions contains the FKey
     @OneToMany(mappedBy = "accounts")
     private Set<Transactions> transactions = new HashSet<>();


}
