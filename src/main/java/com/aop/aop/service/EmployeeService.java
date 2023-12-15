package com.aop.aop.service;

import com.aop.aop.entity.Employee;

import java.util.Optional;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Optional<Employee> getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
