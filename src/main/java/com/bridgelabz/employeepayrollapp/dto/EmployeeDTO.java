/** EmployeeDTO.java */
package com.bridgelabz.employeepayrollapp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import lombok.ToString;
import lombok.Data;
import java.util.List;


public @Data class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
                message = "name shouldn't be null")
    private String name;

    @Min(value = 500,
            message = "Salary must be more than 500")
    private double salary;

    @Pattern(regexp = "male|female",message = "Gender needs to be Male or Female")
    private String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should not be Null")
    @PastOrPresent(message = "startDate should be past or todays date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    private String note;

    @NotBlank(message = "Provide link of Profile Picture")
    private String profilePic;

    @NotNull(message = "Department shouldn't be empty")
    private List<String> departments;




//    public EmployeeDTO(String name, double salary) {
//        this.name = name;
//        this.salary = salary;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
}
