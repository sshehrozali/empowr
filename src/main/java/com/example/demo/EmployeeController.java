package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    // Dependency Injection
    @Autowired
    private EmployeeService employeeService;

    // Employee Test API
    @RequestMapping("api/test")
    public String employeeAPI_test() {
        return "Hi, I am an Employee API!";
    }

    // GET (Employee Login -> By ID -> Primary Key)
    @RequestMapping("/api/login/{id}")
    public List<Performance> employeeDashboard(@PathVariable Integer id) {
        return employeeService.displayEmployeesPerformances(id);
    }
}
