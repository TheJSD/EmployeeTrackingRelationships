package com.codeclan.example.employeetracking.repositories;

import com.codeclan.example.employeetracking.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
