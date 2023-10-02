package com.codeclan.example.employeetracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Column
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JsonIgnoreProperties({"department"})
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public Department(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
