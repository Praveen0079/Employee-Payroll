package com.bridgelabz.employeepayrollapp.controller;
//EmplooyeePayrollController


import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService; //created an object of IEmployeePayrollService

//    http://localhost:8080/employeepayrollservice  to fetch the whole database
    @GetMapping(value = {"", "/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {   //ResponseEntity method created

/* created list to store Employee data and Object of IEmployeePayrollService used to use getEmployeePayrollData
 method inside IEmployeePayrollService class */
        List<Employee> empList = employeePayrollService.getEmployeePayrollData();
/* ResponseDTO constructor used from  class ResponseDTO*/
        ResponseDTO responseDTO = new ResponseDTO("employee data successfully fetched",empList);
/* new ResponseEntity initiated and returned with reponseDTO objected and it's status*/
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

/*  http://localhost:8080/employeepayrollservice/get/2 (2 is empId)  */
    /* to fetch data of particular object or person using a parameter(ID) */
    @GetMapping("/get/{empId}")
/* parameterized ResponseEntity method created and parameter is taken from URI path variable
        using annotation @PathVariable i.e. empId  */
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {

/* employee is a reference variable of class Employee and employee is pointing to
    Object of IEmployeePayrollService class to use getEmployeePayrollDataById method to get data with Id*/
        Employee employee = employeePayrollService.getEmployeePayrollDataById(empId);
/* ResponseDTO constructor used from class ResponseDTO*/
        ResponseDTO responseDTO = new ResponseDTO("employee data successfully fetched by id",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeeDTO empPayrollDTO) {
        Employee employee = null;
        employee = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("created employee data successfully",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeeDTO empPayrollDTO) {
        System.out.println(empId);
        System.out.println(empPayrollDTO.getName());
        System.out.println("Updated");
        Employee employee = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee data successfully",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted employee data successfully",empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}