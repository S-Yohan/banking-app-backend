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
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long transactionId;
    public int posted_to;
    public double deposit_amount;
    public double withdrawal_amount;

    @CreationTimestamp
    public Timestamp time_stamp;



    @ManyToOne
    @JsonBackReference
    @JoinColumn(name= "posted_by")
    private Account account;
}
