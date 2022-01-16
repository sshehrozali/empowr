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
    @Autowired
    private FeedbackRepository feedbackRepository;  // Employee Feedback

    // Return all Performances if the Employee trying to Login has GRANTED ACCESS by Admin
    public List<Performance> displayEmployeesPerformances(Integer id) {
        // id passed should not be NULL or equal to ZERO
        if (id != 0) {
            Optional<Data> checkData = databaseRepository.findById(id);    // First get the Employee Info from the database
            if (checkData != null) {
                if (checkData.get().isEmployeeParticipation()) {
                    List<Performance> performances = new ArrayList<>();
                    performanceRepository.findAll().forEach(performances::add);
                    return performances;    // Return Performances if Employee has ACCESS to submit feedback
                }
            }
        }
        return null;    // If Employee has not ACCESS to submit feedback -> Return NULL
    }

    // Submit Feedback against an Employee by id -> Primary Key
    public void submitFeedback(Integer id, Feedback feedback) {
        // Client ID should not be ZERO
        if (id != 0) {
            // First Check that if Client has GRANTED ACCESS to submit Feedback by Admin or not
            Optional<Data> checkData = databaseRepository.findById(id);
            // If Client is Found in Database
            if (checkData != null) {
                // If Client has ACCESS to submit Feedback
                if (checkData.get().isEmployeeParticipation()) {
                    Optional<Data> checkFeedbackEmployeeData = databaseRepository.findById(feedback.getFeedbackEmployeeID());   // Get Employee ID
                    // Employee should also be in the Database
                    if (checkFeedbackEmployeeData != null) {
                        Optional<Performance> getEmployeePerformanceData = performanceRepository.findById(feedback.getFeedbackEmployeeID());
                        // Admin should have given Performance to the Employee -> Tb hi hosakta hai bhai! :D

                        // Yahan tk sahi hai bhai :D We stay winin
                        System.out.println("Hasan ki key aayegi " + getEmployeePerformanceData.get().getKey());



                        if (getEmployeePerformanceData != null) {
                            // Store Feedback -> Make new Performance Object -> Update in Performance Database
//                            Optional<Performance> newEmployeePeformance = getEmployeePerformanceData.get().setFeedback(feedback.getFeedbackTobeSubmitted());
                            System.out.println("hi");
                        }


                    }
                }
            }
        }
    }
}

