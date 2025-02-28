package com.bridgelabz.employeePayrollApp.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public @ToString  class EmployeeDTO {
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;
    @Min(value=20000, message = "Min Wage should be more than 500")
    private double salary;
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    private String gender;
    @NotBlank(message = "Note cannot be Empty")
    private String note;
    @JsonFormat(pattern = "dd MMM yyy")
    @NotNull(message = "StartDate should be past or today's date")
    private LocalDate startDate;
    @NotBlank(message = "profilePic cannot be Empty")
    private String profilePic;
    @NotNull(message = "department should not be Empty")
    private List<String> department;

}

