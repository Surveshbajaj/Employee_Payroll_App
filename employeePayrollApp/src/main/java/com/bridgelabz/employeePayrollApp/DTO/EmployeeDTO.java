package com.bridgelabz.employeePayrollApp.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public @ToString  class EmployeeDTO {
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;
    private double salary;
    private String gender;
    private String note;
    private String profilePic;
    private List<String> department;

}

