package com.learnspring.employeessystem.dao;

import com.learnspring.employeessystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
