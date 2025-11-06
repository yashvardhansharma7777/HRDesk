package com.HRDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HRDesk.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
 

} 
