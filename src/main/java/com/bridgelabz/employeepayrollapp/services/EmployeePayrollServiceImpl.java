package com.bridgelabz.employeepayrollapp.services;



import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    private List<Employee> employees = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).get();
    }

    public Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO) {
      try{  Employee employee = null;
        employee = new Employee(empPayrollDTO);
        employeeRepository.save(employee);
        return employee;
    }
      catch(Exception e){
      throw new EmployeePayrollException(e.getMessage());
      }
    }

    public Employee updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.getName());
        empData.setSalary(empPayrollDTO.getSalary());
        employeeRepository.save(empData);
        return empData;
    }

    public void deleteEmployeePayrollData(int empId) {
        employeeRepository.deleteById(empId);
    }
}
