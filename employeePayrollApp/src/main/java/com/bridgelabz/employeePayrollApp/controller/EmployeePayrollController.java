package com.bridgelabz.employeePayrollApp.controller;


import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        return "Fetching employee with ID: " + id;
    }
    //UC-04
    @PostMapping("/create")
    public EmployeeModel createEmployee(@RequestParam String name, @RequestParam int salary) {
        return employeeService.createEmployee(name, salary);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id) {
        return "Updating employee with ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return "Deleting employee with ID: " + id;
    }

    @GetMapping("/DTO/get/{name}/{salary}")
    public EmployeeModel getEmployee(@PathVariable String name, @PathVariable int salary) {
        return new EmployeeModel(name,salary); // Returning employee details based on input
    }

    //UC-05
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
