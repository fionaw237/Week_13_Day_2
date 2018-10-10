package com.example.codeclan.employees_lab;

import com.example.codeclan.employees_lab.models.Department;
import com.example.codeclan.employees_lab.models.Employee;
import com.example.codeclan.employees_lab.models.Project;
import com.example.codeclan.employees_lab.repositories.DepartmentRepository;
import com.example.codeclan.employees_lab.repositories.EmployeeRepository;
import com.example.codeclan.employees_lab.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesLabApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;


	@Test
	public void canCreateEmployee() {
		Department department = new Department("development");
		departmentRepository.save(department);

		Employee employee = new Employee("Fiona", "Wilson", 123456789, department);
		department.addEmployee(employee);
		Employee employee2 = new Employee("Joanna", "Wilson", 123456789, department);
		employeeRepository.save(employee);
		employeeRepository.save(employee2);

		Project project1 = new Project("project1", 7);
		Project project2 = new Project("project2", 14);
		projectRepository.save(project1);
		projectRepository.save(project2);


		project1.addEmployee(employee);
		project2.addEmployee(employee);
		employee.addProject(project1);
		employee.addProject(project2);

		project2.addEmployee(employee2);
		employee2.addProject(project2);

		employeeRepository.save(employee);
		employeeRepository.save(employee2);
	}
}
