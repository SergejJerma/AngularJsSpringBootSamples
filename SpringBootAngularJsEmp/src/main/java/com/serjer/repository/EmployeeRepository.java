package com.serjer.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.serjer.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByName(String name);
}