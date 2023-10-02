package com.codeclan.example.employeetracking.controllers;

import com.codeclan.example.employeetracking.models.Department;
import com.codeclan.example.employeetracking.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;
    @GetMapping(value = "/departments")
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }
}
