package com.revature.training.BankingApplication.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Transactions {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionId",nullable = false)
    private int transactionId;
    @Column(name="accountNum")
    @Getter
    @Setter
    private int accountNum;
    @Column(name="transactionType")
    @Getter
    @Setter
    private String transactionType;
    @Column(name="amount")
    @Getter
    @Setter
    private double ammount;
    // need to get the syntax to auto generate a time stamp
    @CreationTimestamp
    @Column(name= "time_stamp")
    @Getter
    @Setter
    private long time_stamp;
}
