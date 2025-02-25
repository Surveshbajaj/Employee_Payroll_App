package com.bridgelabz.employeePayrollApp.controller;

import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.http.ResponseEntity;
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
    //UC-03
    //mappings using DTO for uc3
    @PostMapping("/DTO/create")
    public EmployeeModel createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        return employee;
    }
    @GetMapping("/DTO/get/{name}/{salary}")
    public EmployeeModel getEmployee(@PathVariable String name, @PathVariable double salary) {
        return new EmployeeModel(new EmployeeDTO(name, salary)); // Returning employee details based on input
    }


}
