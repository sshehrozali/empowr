package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    // Dependency Injection
    @Autowired
    private DatabaseRepository databaseRepository;  // Employees Info Database
    @Autowired
    private PerformanceRepository performanceRepository; // Employees Performance

    // Return all Performances if the Employee trying to Login has GRANTED ACCESS by Admin
    public List<Performance> displayEmployeesPerformances(Integer id) {
        // id passed should not be NULL or equal to ZERO
        if (id != 0) {
            Optional<Data> checkData = databaseRepository.findById(id);    // First get the Employee Info from the database
            if (checkData != null) {
                if (checkData.get().isEmployeeParticipation()) {
                    List<Performance> performances = new ArrayList<>();
                    performanceRepository.findAll().forEach(performances::add);
                    return performances;
                }
            }
        }
        return null;    // If Employee has not ACCESS to submit feedback -> Return NULL
    }
}

