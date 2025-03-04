package com.bridgelabz.employeePayrollApp.repository;

import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    // No additional methods needed for now
}
