package com.revature.training.BankingApplication.Model;

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
@Table(name = "users")    //just added this

//The user table is the Parent table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    //all fields have column by default
    private Long userId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phoneNo;
    private String city;

    //Because this is a parent it will have JsonManagedReference
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonManagedReference
    //@JoinColumn(name = "userFk")
    private List<Account> accounts;
}
