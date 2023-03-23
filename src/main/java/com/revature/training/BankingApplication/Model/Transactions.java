package com.revature.training.BankingApplication.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private int posted_to;
    private double depost_amount;
    private double withdrawal_amount;
    // need to get the syntax to auto generate a time stamp
    @CreationTimestamp
    private Timestamp time_stamp;

    @ManyToOne
    @JoinColumn(name= "accountid")
    private Account account;
}
