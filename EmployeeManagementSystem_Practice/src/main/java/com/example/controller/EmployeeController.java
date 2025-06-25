package com.example.controller;

import com.example.entity.Employee;

import com.example.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/employees")

public class EmployeeController {

    @Autowired

    private EmployeeService service;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {

        return service.addEmployee(employee);

    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {

        return service.getEmployee(id);

    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(service.getAllEmployees());

    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {

        return service.updateEmployee(id, employee);

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteEmployee(id);

        return "Employee deleted successfully";

    }

}

