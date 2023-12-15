package com.aop.aop.controller;

import com.aop.aop.entity.Employee;
import com.aop.aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "Employee updated";
    }

    @GetMapping("/getEmployeeById")
    public Optional<Employee> getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmployeeById")
    public void deleteEmployeeById(int id) {
        employeeService.deleteEmployeeById(id);
    }

}
