package com.eventmanagement.eventmanagement.model;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import com.eventmanagement.eventmanagement.enums.TicketType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name="Ticket")
@Data
public class Ticket {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer ticket_id;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    protected TicketType type;

    @Column (name="description")
    private String description;

    @Column(name="price")
    @NotEmpty
    private double price;

}
