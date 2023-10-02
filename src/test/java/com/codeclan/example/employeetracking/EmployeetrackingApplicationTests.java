package com.codeclan.example.employeetracking;

import com.codeclan.example.employeetracking.models.Department;
import com.codeclan.example.employeetracking.models.Employee;
import com.codeclan.example.employeetracking.models.Project;
import com.codeclan.example.employeetracking.repositories.DepartmentRepository;
import com.codeclan.example.employeetracking.repositories.EmployeeRepository;
import com.codeclan.example.employeetracking.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeetrackingApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ProjectRepository projectRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeDepartmentAndProject(){
		Department department1 = new Department("Cool");
		departmentRepository.save(department1);

		Employee employee = new Employee("Bob", 201, 5,"bobdavid@gmail.com", department1);
		employeeRepository.save(employee);

		Project project = new Project("Awesome", 10);
		project.addEmployee(employee);
		projectRepository.save(project);
	}


}
