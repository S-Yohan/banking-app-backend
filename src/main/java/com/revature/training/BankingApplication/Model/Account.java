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
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo; //randomly generated thru the user table
    private String accountType;
    private Double balance;


    /* Note: for Child of this bi-directional relationship
       Format should be:
       @ManyToOne
       @JsonBackReference
       @JoinColumn(name = "name of fkey column in child table")
       private ParentOjbect parentObject;
    */
    //Because this is the child it's going to have a JsonBackedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Users users;

    /* Note: for Parent of bi-directional replationships
       Format should be:
       @JsonManagedReference
       @OneToMany(mappedBy = "name of the parent class"
       private Set<ChildObject> childObject;
       */
    @OneToMany
    (mappedBy = "transactionId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transactions> transactions;

}
