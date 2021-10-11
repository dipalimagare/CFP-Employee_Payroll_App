package com.bridgelabz.employeepayrollapp.dto;


import lombok.*;

@Data
public class EmployeeDTO {
    private String name;
    private long salary;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
