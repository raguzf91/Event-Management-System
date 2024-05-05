package com.eventmanagement.eventmanagement.model;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name="Ticket")
@Data
public class Ticket {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected String type;

    @Column (name="description")
    private String description;

    @Column(name="price")
    @NotEmpty
    private double price;

}
