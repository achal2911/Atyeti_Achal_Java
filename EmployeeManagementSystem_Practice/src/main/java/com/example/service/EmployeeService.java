package com.example.service;

import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repo) {
    }

    public Employee addEmployee(Employee employee) {
        if (employee.getName() == null || employee.getEmail() == null || employee.getDepartment() == null) {
            throw new IllegalArgumentException("Employee details cannot be null");
        }
        return repository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

    public List<Employee> getAllEmployees() {
        if (repository.count() == 0) {
            throw new EmployeeNotFoundException("No employees found");
        }
        return repository.findAll();
    }
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = repository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());
            return repository.save(employee);
        }
        throw new EmployeeNotFoundException("Employee not found with ID: " + id);
    }

    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}