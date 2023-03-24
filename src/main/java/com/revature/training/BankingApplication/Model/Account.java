package com.revature.training.BankingApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")

//account table is the child table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
   //@Column annotation is not used because all field have columns by default
    private String accountNo;
    private String accountOwner;
    private String accountType;
    private Double balance;


    //Because this is the child it's going to have a JsonBackedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
   // @JsonBackReference
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany
    (mappedBy = "transactionId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transactions> transactions = new HashSet<>();

}
