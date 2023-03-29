package com.revature.training.BankingApplication.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

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
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private String city;

    @JsonManagedReference
    @JoinColumn(name = "accountFK")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //mappedBy = "users",
    private Set<Account> accounts = new HashSet<>();



}
    /* Note: for Parent of bidirectional relationships
    Format should be:
    @JsonManagedReference
    @OneToMany(mappedBy = "name of the parent class"
    private Set<ChildObject> childObject;*/