package com.aop.aop.serviceimpl;

import com.aop.aop.entity.Employee;
import com.aop.aop.repository.EmployeeRepository;
import com.aop.aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        boolean exists = employeeRepository.existsById(employee.getId());
        if (exists) {
            employeeRepository.saveAndFlush(employee);
        } else {
            throw new RuntimeException("There is not employee with id " + employee.getId());
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
