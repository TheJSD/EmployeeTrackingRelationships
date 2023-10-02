package com.codeclan.example.employeetracking.repositories;

import com.codeclan.example.employeetracking.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
