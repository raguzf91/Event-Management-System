package com.eventmanagement.eventmanagement.model;

import java.time.LocalDateTime;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

   
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer id;

    @NotEmpty
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @NotEmpty
    @Column(name="location")
    private String location;

    @Column(name="max_capacity")
    private int maxCapacity;

    @Column(name="registration_deadline")
    private LocalDateTime registrationDeadline;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Event", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="EventCategory", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories;


    
}
