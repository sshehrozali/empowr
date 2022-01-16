package com.example.demo;// Import Database Packages -> Classes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    // Dependency Injection
    @Autowired
    private AdminService adminService;

    // Admin Test API
    @RequestMapping("api/admin/test")
    public String adminAPI_test() {
        return "Hi, I am an Admin API!";
    }

    // GET (All Employee Data)
    @RequestMapping("api/admin/employee/all")
    public List<Data> viewAll() {
        return adminService.viewAllData();
    }

    // GET (Specific Employee Data)
    @RequestMapping("api/admin/employee/view/{id}")
    public Optional<Data> viewSpecific(@PathVariable Integer id) {
        return adminService.viewSpecificData(id);
    }

    // POST (Create New Employee Data)
    @RequestMapping(method = RequestMethod.POST, value = "api/admin/employee/create")
    public void create(@RequestBody Data data) {
        adminService.createEmployee(data);
    }

    // PUT (Update Employee Data)
    @RequestMapping(method = RequestMethod.PUT, value = "api/admin/employee/update/{id}")
    public void update(@RequestBody Data data, @PathVariable Integer id) {
        adminService.updateEmployee(id, data);
    }

    // DELETE (Delete Employee Data)
    @RequestMapping(method = RequestMethod.DELETE, value = "api/admin/employee/delete/{id}")
    public void delete(@PathVariable Integer id) {
        adminService.deleteEmployee(id);
    }

    // GET (Show All Employees Performances with their IDs -> Primary Key)
    @RequestMapping("api/admin/performance/all")
    public List<Performance> performances() {
        return adminService.showAllPerformances();
    }

    // POST (Set Performance of the Employee by ID -> Primary Key)
    @RequestMapping(method = RequestMethod.POST, value = "api/admin/performance/add")
    public void addPerformance(@RequestBody Performance performance) {
        adminService.addEmployeePerformance(performance);
    }

    // PUT (Update Performance of the Employee by ID -> Primary Key)
    @RequestMapping(method = RequestMethod.PUT, value = "api/admin/performance/update/{id}")
    public void updatePerformance(@RequestBody Performance performance, @PathVariable Integer id) {
        adminService.updateEmployeePerformance(id, performance);
    }
}
