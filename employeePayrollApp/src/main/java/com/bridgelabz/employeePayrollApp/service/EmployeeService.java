package com.bridgelabz.employeePayrollApp.service;

import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //Add employee to the list
    List<EmployeeModel> employeeList = new ArrayList<>();
    public EmployeeModel createEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employee = new EmployeeModel(employeeDTO.getId(),employeeDTO.getName(),employeeDTO.getSalary(),employeeDTO.getGender(),employeeDTO.getNote(), employeeDTO.getStartDate(),employeeDTO.getProfilePic(),employeeDTO.getDepartment());
        employeeList.add(employee);
        log.info("Creating a Employee With Name: {} ", employee.getName());
        EmployeeModel savedEmployee = employeeRepository.save(employee);
        log.info("Successfully a employee Created {}", employee);
        return savedEmployee;
    }
    //get by id
    public EmployeeModel getEmployeeById(int id) {
        log.debug("Searching for Employee By Id {}" , id);
        // Return employee if found, otherwise return null
        return employeeRepository.findById(id).orElse(null);
    }
    public List<EmployeeModel> getAllEmployees() {
        // Return all employees in the list
        return employeeRepository.findAll();
    }
    public EmployeeModel updateEmployee(int id,  EmployeeDTO updatedEmployee) {

        EmployeeModel employee = employeeRepository.findById(id).orElse(null);

        if(employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setProfilePic(updatedEmployee.getProfilePic());
            employee.setNote(updatedEmployee.getNote());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setGender(updatedEmployee.getGender());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setStartDate(updatedEmployee.getStartDate());
            employeeRepository.save(employee);
            log.info("Successfully Employee Details Updated ......");
            return new EmployeeModel(updatedEmployee.getId(),updatedEmployee.getName(), updatedEmployee.getSalary(), updatedEmployee.getGender(), updatedEmployee.getNote(), updatedEmployee.getStartDate(), updatedEmployee.getProfilePic(), updatedEmployee.getDepartment());
        }
        // Return null if no matching employee is found
        return null;
   }

    // Delete Employee
    public boolean deleteEmployee(int id) {
        log.debug("Deleting the Employee Whose id is {}" , id);
        // Remove employee with the given ID
        if((employeeRepository.existsById(id))) {
            employeeRepository.deleteById(id);
            return true;
        }
        // return false for employee not found with given id
        return false;
    }

    public void testLogging() {
        log.debug("This is a DEBUG message - visible in dev mode");
        log.info("This is an INFO message - visible in all modes");
        log.warn("This is a WARN message");
        log.error("This is an ERROR message");
    }



}
