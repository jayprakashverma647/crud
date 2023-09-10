package com.api.crud.Entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private int eid;
@NotNull
    private String name;

    private String city;
 @Email

    private String email;
}
