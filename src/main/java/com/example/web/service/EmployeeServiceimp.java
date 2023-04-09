package com.example.web.service;

import com.example.web.Dao.EmployeeRepository;
import com.example.web.exception.ResourceNotFoundException;
import com.example.web.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimp implements EmployeeService {
   private EmployeeRepository employeeRepository;

    public EmployeeServiceimp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getALlEmployee() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

//        Optional<Employee>  emp = employeeRepository.findById(id);
//        if(emp.isPresent()){
//            emp.get();
//        }
        return  employeeRepository.findById(id).orElseThrow(()->   new ResourceNotFoundException("employee","Id",id));


    }

    @Override
    public Employee updateEmployee(Employee employee, Long Id) {
        //we need to check whether the id is in the data base or not
        Employee exitingEmployee = employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("employee","Id",Id));
        //set the exitingEmployee

          exitingEmployee.setFirstname(employee.getFirstname());
          exitingEmployee.setLastName(employee.getLastName());
        exitingEmployee.setEmail(employee.getEmail());



                employeeRepository.save(exitingEmployee);
            return    exitingEmployee;
    }

    @Override
    public void deleteEmployee(Long Id) {
        //check if the already admin is in the data or not
        //
        employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("employee","Id",Id));
             employeeRepository.deleteById(Id);
    }
}
