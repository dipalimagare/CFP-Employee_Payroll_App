package com.bridgelabz.employeepayrollapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private long salary;
}
