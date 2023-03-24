package com.revature.training.BankingApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
   // @JsonBackReference
    @JoinColumn(name = "user_id")
    private Users users;

}
