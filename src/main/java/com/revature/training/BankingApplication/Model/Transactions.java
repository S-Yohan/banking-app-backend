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
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private double deposit_amount;
    private String transactionType;
    @CreationTimestamp
    private Timestamp time_stamp;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name= "AccountFK")
    private Account account;
}

    /* Note: for Child of this bidirectional relationship
        Format should be:
        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "name of fkey column in child table")
        private ParentOjbect parentObject;
     */
