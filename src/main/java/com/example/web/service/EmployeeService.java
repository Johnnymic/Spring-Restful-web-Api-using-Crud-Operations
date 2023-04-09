package com.example.web.service;

import com.example.web.model.Employee;

import java.util.List;

public interface EmployeeService {
  Employee saveEmployee(Employee employee);

  List<Employee> getALlEmployee();

  Employee getEmployeeById(Long id);

  Employee updateEmployee(Employee employee, Long Id);

  void deleteEmployee( Long id);

}
