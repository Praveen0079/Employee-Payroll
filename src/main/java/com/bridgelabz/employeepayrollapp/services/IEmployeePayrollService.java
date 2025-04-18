//IEmplooyeePayrollService

package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    public List<Employee> getEmployeePayrollData();
    public Employee getEmployeePayrollDataById(int empId);
    public Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO);
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO);
    public void deleteEmployeePayrollData(int empId);
}
