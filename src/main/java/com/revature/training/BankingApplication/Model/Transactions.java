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
    private double account_debited;
    private double account_credited;
    private double transamount;
    private String transtype;
    @CreationTimestamp
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "accountFK")
    @JoinColumn
    private Account account;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "userKey")
    public Users users;

}

    /* Note: for Child of this bidirectional relationship
        Format should be:
        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "name of fkey column in child table")
        private ParentOjbect parentObject;
     */



