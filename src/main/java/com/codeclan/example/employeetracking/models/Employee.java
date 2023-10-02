package com.codeclan.example.employeetracking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Column(name="name")
    private String name;
    @Column(name="employee_number")
    private int employeeNumber;
    @Column(name="age")
    private int age;
    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties({"employee"})
    private Department department;

    @ManyToMany
    @JsonIgnoreProperties("employees")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "project_employees",
            joinColumns = {
                    @JoinColumn(
                            name = "employee_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "project_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Project> projects;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Employee(String name, int employeeNumber, int age, String email, Department department) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.age = age;
        this.email = email;
        this.department = department;
        this.projects = new ArrayList<>();
    }
    public Employee(){};

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
