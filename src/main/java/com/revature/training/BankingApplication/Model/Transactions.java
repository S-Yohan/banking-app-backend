package com.revature.training.BankingApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private int posted_to;
    private double deposit_amount;
    private double withdrawal_amount;
    // need to get the syntax to auto generate a time stamp
    @CreationTimestamp
    private Timestamp time_stamp;

    /*@ManyToOne
    @JsonBackReference
    @JoinColumn(name= "posted_by")
    private Account account;*/
}
