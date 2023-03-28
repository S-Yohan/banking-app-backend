package com.revature.training.BankingApplication.Model;


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
@Table(name = "users")    //just added this

//The user table is the Parent table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    //all fields have column by default
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private String city;

    /* Note: for Parent of bi-directional replationships
    Format should be:
    @JsonManagedReference
    @OneToMany(mappedBy = "name of the parent class"
    private Set<ChildObject> childObject;
  */
    //Because this is a parent it will have JsonManagedReference
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();
    //@JsonManagedReference
    //@JoinColumn(name = "userFk")


}
