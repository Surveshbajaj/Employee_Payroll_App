package com.bridgelabz.employeePayrollApp.model;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public @Data class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String name;
    private double salary;
    private String gender;
    private String note;
    private String profilePic;
    private List<String> department;


    public EmployeeModel(){}

//    public EmployeeModel(int id, EmployeeDTO employeeDTO) {
//        this.id = id;
//        this.name = employeeDTO.getName();
//        this.salary = employeeDTO.getSalary();
//        this.department = employeeDTO.getDepartment();
//        this.profilePic = employeeDTO.getProfilePic();
//        this.note = employeeDTO.getNote();
//        this.gender = employeeDTO.getGender();
//    }

    public EmployeeModel(int id, String name, double salary, String gender, String note, String profilePic, List<String> department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }


//    public EmployeeModel(@NotEmpty(message = "Name cannot be empty") @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long") String name, double salary) {
//    }

}
