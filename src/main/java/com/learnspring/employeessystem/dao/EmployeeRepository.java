package com.learnspring.employeessystem.dao;

import com.learnspring.employeessystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members") // to change the endpoint path so instead of employees it will be members.
// note that the name come from the entity name then add to it 's'
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
