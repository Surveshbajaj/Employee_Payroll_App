package com.bridgelabz.employeePayrollApp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        return "Fetching employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee() {
        return "Creating new employee!";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id) {
        return "Updating employee with ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return "Deleting employee with ID: " + id;
    }


}
