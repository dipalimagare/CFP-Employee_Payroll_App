package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.*;
import com.bridgelabz.employeepayrollapp.exception.*;
import com.bridgelabz.employeepayrollapp.model.*;
import com.bridgelabz.employeepayrollapp.repository.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Class for the business logic for Employeepayroll App Controller service
 *
 * @author Dipali Ravindra Magare
 * @version 0.0.1
 * @since 11-10-2021
 */

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
        public static List<EmployeeEntity> employees(){
                return employeeRepository.findAll();
        }


        /**
         * @param id
         * @return
         */
        public EmployeeEntity getEmployeeById(int id){
                Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }


        /**
         * @param name
         * @return {@Link Employee }
         */
        public EmployeeEntity getEmployeeByName(String name){
                Optional<EmployeeEntity> employeeEntity = employeeRepository.findByfirstName(name);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        /**
         * @param salary
         * @return {@Link Employee }
         */
        public EmployeeEntity getEmployeeBySalary(long salary){
                Optional<EmployeeEntity> employeeEntity = employeeRepository.findBySalary(salary);
                if (employeeEntity.isPresent()){
                        return employeeEntity.get();
                }
                return null;
        }

        /**
         * @param employeeDTO
         * @return {@Link EmployeeEntity }
         */
        public EmployeeEntity addEmployee(EmployeeDTO employeeDTO){
                EmployeeEntity employeeEntity = new EmployeeEntity();
                modelMapper.map(employeeDTO, employeeEntity);
                return employeeRepository.save(employeeEntity);
        }

        /**
         * @param id
         * @return
         */
        public String deleteEmployee(int id){
                Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
                if(employeeEntity.isPresent()){
                        employeeRepository.delete(employeeEntity.get());
                        return "Employee Record is deleted successfully.";
                }
                throw new CustomException("Record does not exist with this id:"+id);
        }

        /**
         * @param employeeDTO
         * @return {@Link EmployeeEntity }
         */

        public EmployeeEntity updateEmployee(int id, EmployeeDTO employeeDTO) {
                Optional<EmployeeEntity> optionalStudentEntity = employeeRepository.findById(id);
                if(optionalStudentEntity.isPresent()) {
                        EmployeeEntity employeeEntity = optionalStudentEntity.get();
                        employeeEntity.setId(employeeDTO.getId());
                        employeeEntity.setFirstName(employeeDTO.getName());
                        employeeEntity.setLastName(employeeDTO.getName());
                        employeeEntity.setSalary(employeeDTO.getSalary());
                        return employeeRepository.save(employeeEntity);
                }
                return null;
        }

}

