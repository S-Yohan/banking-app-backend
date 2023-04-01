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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String address;
    private long secureToken;

    @JsonManagedReference (value="userFK")
    // mapped by references the object created in the BackReference
    @OneToMany(mappedBy = "users", cascade = {CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Account> accounts;

    @OneToMany(mappedBy = "users", cascade = {CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "userKey")
    private List<Transactions> transactions;



}
    /* Note: for Parent of bidirectional relationships
    Format should be:
    @JsonManagedReference
    @OneToMany(mappedBy = "name of the parent class"
    private Set<ChildObject> childObject;*/