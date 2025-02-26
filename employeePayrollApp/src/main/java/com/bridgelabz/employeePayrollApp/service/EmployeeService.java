package com.bridgelabz.employeePayrollApp.service;

import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    //Add employee to the list
    List<EmployeeModel> employeeList = new ArrayList<>();
    public EmployeeModel createEmployee(String name, int salary){
        EmployeeModel employee = new EmployeeModel(name,salary);
        employeeList.add(employee);
        return employee;
    }
    //list of all the employee
    public List<EmployeeModel> getAllEmployees(){
        return employeeList;
    }
}
