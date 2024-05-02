package com.eventmanagement.eventmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;



@MappedSuperclass
public class BaseEntity {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @JsonIgnore
    public boolean isNew() {
        return this.ID == null;
    }
}
