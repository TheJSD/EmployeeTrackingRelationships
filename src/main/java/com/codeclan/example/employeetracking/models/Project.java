package com.codeclan.example.employeetracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Column
    private String name;
    @Column
    private int duration;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JsonIgnoreProperties("projects")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "project_employees",
            joinColumns = {
                    @JoinColumn(
                            name = "project_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "employee_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Employee> employees;

    public Project(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.employees = new ArrayList<>();
    }

    public Project(){}

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
