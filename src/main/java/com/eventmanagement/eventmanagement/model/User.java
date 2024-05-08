package com.eventmanagement.eventmanagement.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User")
@Data
@NoArgsConstructor
public class User extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer user_id;
    @Column(name="password")
    @NotEmpty
    private String password;
    @Column(name="bio")
    private String bio;
    @Column(name="enabled")
    @NotEmpty
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "User", fetch = FetchType.EAGER)
    private Set<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "User", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    public User(String firstName, String lastName, String email, Integer age, Integer id, String password, String bio, boolean enabled) {
        super(firstName, lastName, email, age);
        this.user_id = id;
        this.password = password;
        this.bio = bio;
        this.enabled = enabled;
        this.reviews = null;
        //this.category = determineCategory();
        this.tickets = null;


    }
    
}
