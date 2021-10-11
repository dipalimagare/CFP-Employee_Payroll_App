package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;
import org.mockito.junit.jupiter.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;

import java.util.*;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = EmployeeController.class)
//@RunWith(MockitoJUnitRunner.class)
public class EmployeeEntityControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeePayrollService employeePayrollService;

    @Test
    public void EmployeePayrollTest() {


    }
}
