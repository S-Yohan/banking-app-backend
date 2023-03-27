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
    private long transactionId;
    //private int posted_to;
    private double deposit_amount;
   // private double withdrawal_amount;
    private String transactionType;
    @CreationTimestamp
    private Timestamp time_stamp;


    /* Note: for Child of this bi-directional relationship
        Format should be:
        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "name of fkey column in child table")
        private ParentOjbect parentObject;
     */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name= "posted_to")
    private Account account;
}
