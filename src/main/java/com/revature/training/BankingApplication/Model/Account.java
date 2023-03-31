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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")


public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long accountNumber;
    private String type;
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference // returned to what it was as it was correct the first time.
    @JoinColumn(name = "userFK") //CURRENTLY THESE ARE JOINING ON DIFFERENT COLUMNS
    private Users users;


    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //mappedBy = "account",
    @JsonManagedReference
    @JoinColumn(name= "accountFK") // corrected so they are pointing to the same column
    private List <Transactions> transactions;

}
 /* Note: for Child of this bi-directional relationship
       Format should be:
       @ManyToOne
       @JsonBackReference
       @JoinColumn(name = "name of fkey column in child table")


      /* private ParentOjbect parentObject;
           /* Note: for Parent of bidirectional relationships
       Format should be:
       @JsonManagedReference
       @OneToMany(mappedBy = "name of the parent class"
       private Set<ChildObject> childObject;
       */

  /*  @OneToMany
   (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name= "posted_to")
    private Set<Transactions> transactions;*/



