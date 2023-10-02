package com.codeclan.example.employeetracking.controllers;

import com.codeclan.example.employeetracking.models.Employee;
import com.codeclan.example.employeetracking.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
