package com.api.crud.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private int eid;
    private String name;
    private String city;
    private String email;
}
