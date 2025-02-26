package com.bridgelabz.employeePayrollApp.service;

import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeModel createEmployee(String name, int salary){
        return new EmployeeModel(name,salary);
    }
}
