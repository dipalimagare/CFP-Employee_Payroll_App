package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.*;
import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.repository.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class EmployeePayrollService {

        @Autowired
        private static EmployeeRepository employeeRepository;

        @Autowired
        private ModelMapper modelMapper;

        /**
         * Function to get the List of all employee stored in DB
         * @return List of employee payroll data
         */
        public static List<Employee> employees(){
                return employeeRepository.findAll();
        }


        /**
         * @param id
         * @return
         */
        public Employee getEmployeeById(int id){
                Optional<Employee> employeeEntity = employeeRepository.findById(id);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }


        /**
         * @param name
         * @return {@Link Employee }
         */
        public Employee getEmployeeByName(String name){
                Optional<Employee> employeeEntity = employeeRepository.findByName(name);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        /**
         * @param salary
         * @return {@Link Employee }
         */
        public Employee getEmployeeBySalary(long salary){
                Optional<Employee> employeeEntity = employeeRepository.findBySalary(salary);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        /**
         * @param employee
         * @return {@Link Employee }
         */
        public Employee addEmployee(Employee employee){
                Employee employee1 = new Employee();
                modelMapper.map(employee, employee);
                return employeeRepository.save(employee);
        }

        /**
         * @param id
         * @return
         */
        public String deleteEmployee(int id){
                Optional<Employee> employeeEntity = employeeRepository.findById(id);
                if(employeeEntity.isPresent()){
                        employeeRepository.delete(employeeEntity.get());
                        return "Employee Record is deleted successfully.";
                }
                return "Record does not exists with this id : " + id;
        }

        /**
         * @param employee
         * @return {@Link Employee }
         */
        public Employee updateEmployee(Employee employee){
                return employeeRepository.save(employee);
        }


}
