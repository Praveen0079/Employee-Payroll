//employee_repository
package com.bridgelabz.employeepayrollapp.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.employeepayrollapp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}