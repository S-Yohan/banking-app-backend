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
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String address;
    private long secureToken;

    @JsonManagedReference
    @JoinColumn(name = "userFK")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;



}
    /* Note: for Parent of bidirectional relationships
    Format should be:
    @JsonManagedReference
    @OneToMany(mappedBy = "name of the parent class"
    private Set<ChildObject> childObject;*/