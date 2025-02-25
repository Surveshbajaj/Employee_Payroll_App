package com.bridgelabz.employeePayrollApp.controller;

import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
    //UC-01
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to the Employee payroll app";
    }
    @PostMapping("/add")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeModel; //not storing in database yet
    }
}
