package com.eventmanagement.eventmanagement.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SpecialGuest extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="EventGuest", joinColumns = @JoinColumn(name = "guest_id"), inverseJoinColumns = @JoinColumn(name="event_id"))
    private Set<Event> events;

    


}
