//EmployeePayrollData
package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_Id")
    private int employeeid;

    @Column(name = "Name")
    private String name;

    private double salary;

    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "Employee_Department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee(EmployeeDTO employeeDTO) {
        this.employeeid = employeeid;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.note = employeeDTO.getNote();
        this.startDate = employeeDTO.getStartDate();
        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments();
    }

//    public long getEmployeeid() {
//        return employeeid;
//    }
//
//    public void setEmployeeid(int employeeid) {
//        this.employeeid = employeeid;
//    }
//
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

    public Employee() {
    }
//
//    public Employee(int employeeid, String name, double salary) {
//        this.employeeid = employeeid;
//        this.name = name;
//        this.salary = salary;
//    }
}