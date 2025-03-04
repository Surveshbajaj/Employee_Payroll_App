package com.bridgelabz.employeePayrollApp.model;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public @Data class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
   private String name;
    @Column(name = "salary")
    private double salary;
    @Column(name = "gender")
    private String gender;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "note")
    private String note;
    @Column(name = "profilePic")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;


    public EmployeeModel(){}


    public EmployeeModel(int id, String name, double salary, String gender, String note, LocalDate startDate, String profilePic, List<String> department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }




}
