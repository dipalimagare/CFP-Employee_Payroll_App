package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class EmployeePayrollService {

        @Autowired
        private static EmployeeRepository employeeRepository;

        public static List<Employee> employees(){
                return employeeRepository.findAll();
        }

        public Employee getEmployeeById(int id){
                Optional<Employee> employeeEntity = employeeRepository.findById(id);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        public Employee getEmployeeByName(String name){
                Optional<Employee> employeeEntity = employeeRepository.findByName(name);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        public Employee getEmployeeBySalary(long salary){
                Optional<Employee> employeeEntity = employeeRepository.findBySalary(salary);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        public Employee addEmployee(Employee employee){
                return employeeRepository.save(employee);
        }

        public String deleteEmployee(int id){
                Optional<Employee> employeeEntity = employeeRepository.findById(id);
                if(employeeEntity.isPresent()){
                        employeeRepository.delete(employeeEntity.get());
                        return "Employee Record is deleted successfully.";
                }
                return "Record does not exists with this id : " + id;
        }

        public Employee updateEmployee(Employee employee){
                return employeeRepository.save(employee);
        }


}
