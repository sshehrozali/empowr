package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    // Dependency Injection
    @Autowired
    private DatabaseRepository databaseRepository;  // Employees Info Database
    @Autowired
    private PerformanceRepository performanceRepository; // Employees Performance

    // ALL GET METHODS //
    // All Employee Data
    public List<Data> viewAllData() {
        List<Data> data = new ArrayList<>();
        databaseRepository.findAll().forEach(data::add);
        return data;    // Return all Employee Data if present otherwise []
    }
    // Specific Employee Data
    public Optional<Data> viewSpecificData(Integer id) {
        return databaseRepository.findById(id);
    }
    // Show All Performances
    public List<Performance> showAllPerformances() {
        List<Performance> performances = new ArrayList<>();
        performanceRepository.findAll().forEach(performances::add);
        return performances;    // Return all Performances if present otherwise return []
    }

    // ALL POST METHODS //
    // Creates a new Employee
    public void createEmployee(Data data) {
        // Save in Database if data passed is not NULL
        if (data != null) {
            databaseRepository.save(data);
            System.out.println("Employee Data Saved");
        }
    }
    // Sets New Performance for the Employee
    public void addEmployeePerformance(Performance performance) {
        // performance Object should not be NULL
        if (performance != null) {
            Integer ID = performance.getKey();
            Optional<Data> Employee = databaseRepository.findById(ID);  // Fetch Employee data by using Key -> RDBMS
            // If Employee is Registered in Main Database -> Data -> Then add Employee Performance
            if (Employee.isPresent()) {
                String Name = Employee.get().getEmployeeName();
                System.out.println("Employee: " + Name + " Performance has been added");

                performanceRepository.save(performance);    // Add in Performance Database
                System.out.println("Employee Performance Added");
            }
        } else {
            System.out.println("Data is Empty or Employee ID is not provided");
        }
    }

    // ALL PUT METHODS //
    // Updates Employee Data
    public void updateEmployee(Integer id, Data data) {
        // data & id should not be NULL
        if (data != null && id != null && id != 0) {
            Optional<Data> checkData = databaseRepository.findById(id);
            if (checkData == null) {
                System.out.println("Employee not Found with ID:" + id);
            } else {
                databaseRepository.save(data);  // Updates Employee data if Employee ID is found
            }
        } else {
            System.out.println("Employee data & ID should not be NULL");    // Throw exception (if ID or Data is NULL)
        }
    }
    // Updates Employee Performance
    public void updateEmployeePerformance(Integer id, Performance performance) {
           if (performance != null && id != 0) {
               Optional<Performance> checkPerformance = performanceRepository.findById((id));
               if (checkPerformance != null) {
                   Integer Key = checkPerformance.get().getKey();   // Get the Primary Key of the Employee from Performance Database
                   performanceRepository.save(performance);         // Replace the old Employee Performance data with new one
                   System.out.println("Performance Updated of Employee: " + databaseRepository.findById(Key).get().getEmployeeName());    // Get Employee Name By Using the same Primary Key from Employee Database
               }
           }
    }

    // ALL DELETE METHODS //
    // Deletes Employee Data
    public void deleteEmployee(Integer id) {
        // id should not be NULL and ZERO
        if (id != null && id != 0) {
            databaseRepository.deleteById(id);
            System.out.println("Employee with ID:" + id + "Deleted");
        }
    }
}
