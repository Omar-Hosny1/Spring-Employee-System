package com.learnspring.employeessystem.rest;

import com.learnspring.employeessystem.entity.Employee;
import com.learnspring.employeessystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int id) {
        var employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee Not Found - " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        final Employee employee = employeeService.findById(theEmployee.getId());
        if (employee == null) {
            throw new RuntimeException("No Employee Found - " + theEmployee.getId());
        }
        return employeeService.update(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId) {
        final Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("No Employee Found - " + employeeId);
        }
        System.out.println("DELETING");
        employeeService.deleteById(employeeId);
        System.out.println("DELETETED");
        return new ResponseEntity<>("Employee with this ID Deleted Successfully - " + employeeId, HttpStatus.OK);
    }

}
