package com.example.springbootc.service;

import com.example.springbootc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}
