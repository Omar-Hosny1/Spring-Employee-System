package com.learnspring.employeessystem.dao;

import com.learnspring.employeessystem.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void deleteById(int id);

}
