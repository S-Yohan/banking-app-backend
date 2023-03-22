package com.revature.training.BankingApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Savings {
   //creating the primary key, setting to auto generate, and not able to change to null
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int savingsId;

    private int accountNumber;

    private double balance;

     // error until I have the rest of the classes and interfaces.
     @OneToOne(fetch = FetchType.EAGER)
     @JsonBackReference
     @JoinColumn(name = userId)
     private User user;

     // do I need another to go one to one to transactions?
}
