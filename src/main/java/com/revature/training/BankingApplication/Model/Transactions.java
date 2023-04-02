package com.revature.training.BankingApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transid;
    private long account_debited;
    private long account_credited;
    private double transamount;
    private String transtype;
    @CreationTimestamp
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn//(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Transactions(long account_credited, double transamount,
                        String transtype){
        this.account_credited = account_credited;
        this.transamount = transamount;
        this.transtype = transtype;

    }

}

    /* Note: for Child of this bidirectional relationship
        Format should be:
        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "name of fkey column in child table")
        private ParentOjbect parentObject;
     */



