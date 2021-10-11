package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.*;
import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    // CRUD
    //read
    //creating
    //updating
    //deleting

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/employees")
    public List<EmployeeEntity> employees(){
        return EmployeePayrollService.employees();
    }

    @GetMapping(value = "/get-employee-by-id")
    public EmployeeEntity getEmployeeById(@RequestParam int id){
        return employeePayrollService.getEmployeeById(id);
    }

    @GetMapping(value = "/get-employee-by-Name")
    public EmployeeEntity getStudentByName(@RequestParam String name) {
        return employeePayrollService.getEmployeeByName(name);
    }

    @GetMapping(value = "/get-employee-by-salary")
    public EmployeeEntity getEmployeeBySalary(@RequestParam long salary){
        return employeePayrollService.getEmployeeBySalary(salary);
    }

    @PostMapping(value = "/employee")
    public EmployeeEntity addStudent(@RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.addEmployee(employeeDTO);
    }

    @PutMapping(value = "/employee")
    public EmployeeEntity updateEmployee( @PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(value = "/employee")
    public String deleteEmployee(@RequestParam int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
