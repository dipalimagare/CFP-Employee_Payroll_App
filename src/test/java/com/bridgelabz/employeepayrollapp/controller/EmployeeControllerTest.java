package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.service.*;
import lombok.*;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    public void EmployeePayrollTest(){
        Employee employee = new Employee();
        employee.setName("Dipali");
        employee.setSalary(20000);
        employee.setId(1);
        Employee employee1 = new Employee();
        employee.setName("Kalpesh");
        employee.setSalary(20000);
        employee.setId(2);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        when(employeePayrollService.employees()).thenReturn((List<Employee>) employee);
        //ArrayList<Employee> employees = employeeController.employees();
        Assertions.assertEquals(2, employees.size());
    }


}
