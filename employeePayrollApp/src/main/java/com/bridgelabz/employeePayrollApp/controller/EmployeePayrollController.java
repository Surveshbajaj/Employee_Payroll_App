package com.bridgelabz.employeePayrollApp.controller;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeePayrollController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
        
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee with ID: {}", id);
        return ResponseEntity.ok("Fetching employee with ID: " + id);
    }

    // UC-04: Create Employee
    @PostMapping("/create")
    public ResponseEntity<EmployeeModel> createEmployee(@Valid  @RequestBody EmployeeDTO employeeDTO) {
        log.info("Creating Employee: {}", employeeDTO);
        EmployeeModel employee = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

//     Update Employee by id
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable int id,@Valid  @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating Employee: {}", id);
        EmployeeModel updatedEmployee = employeeService.updateEmployee(id, employeeDTO);

        if (updatedEmployee == null) {
            log.warn("Failed to update - Employee not found: {}", id);
            return ResponseEntity.notFound().build();
        }

        log.info("Employee updated successfully: {}", updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee by Name
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        log.info("Deleting Employee: {}, Success: {}", id, isDeleted);

        if (isDeleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    // UC-05: Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        log.info("Fetching all employees...");
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Test Logging
    @GetMapping("/testLogging")
    public ResponseEntity<String> testLogging() {
        employeeService.testLogging();
        return ResponseEntity.ok("Logging has been tested. Check logs for details.");
    }



}
