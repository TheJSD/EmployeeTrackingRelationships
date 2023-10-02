package com.codeclan.example.employeetracking.repositories;

import com.codeclan.example.employeetracking.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
