package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Submit Feedback -> (id -> POST_REQUEST_CLIENT_ID, feedback -> JSON{EMPLOYEE_ID, FEEDBACKTOBESUBMITTED})
    @RequestMapping(method = RequestMethod.POST, value = "/api/submit/{id}")
    public void submit(@RequestBody Feedback feedback, @PathVariable Integer id) {
        employeeService.submitFeedback(id, feedback);
    }
}
