package com.bridgelabz.employeepayrollapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;
}
