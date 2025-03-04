package com.bridgelabz.employeePayrollApp.repository;

import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    @Query(value = "SELECT e.* FROM employee e JOIN department ed ON e.id = ed.id WHERE ed.department = :department", nativeQuery = true)
    List<EmployeeModel> findEmployeeByDepartment(String department);


}
