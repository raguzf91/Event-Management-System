package com.eventmanagement.eventmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    
    @Column(name="first_name")
    @NotEmpty
    protected String firstName;

    @Column(name="last_name")
    @NotEmpty
    protected String lastName;

    @Column(name="email")
    @NotEmpty
    @Email
    protected String email;

    @Column(name="age")
    @NotEmpty
    protected Integer age;

}
