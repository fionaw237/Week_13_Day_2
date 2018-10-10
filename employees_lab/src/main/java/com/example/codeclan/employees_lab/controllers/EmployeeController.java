package com.example.codeclan.employees_lab.controllers;

import com.example.codeclan.employees_lab.models.Department;
import com.example.codeclan.employees_lab.models.Employee;
import com.example.codeclan.employees_lab.repositories.DepartmentRepository;
import com.example.codeclan.employees_lab.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
