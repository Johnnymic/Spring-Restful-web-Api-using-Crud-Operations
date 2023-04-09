package com.example.web.controller;

import com.example.web.model.Employee;
import com.example.web.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class controller {

  private EmployeeService employeeService;

    public controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //build create employee rest api
   @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }
    //build  get all employee Rest Api


    @GetMapping()
   public List<Employee> getAllEmployee(){
   return  employeeService.getALlEmployee();
   }

   //build get emploee by id REST aPI

    @GetMapping("{id}")
    public ResponseEntity<Employee>  getEmployeeById( @PathVariable("id")  Long id ){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }



    @PutMapping("{Id}")
    public ResponseEntity<Employee>  updateEmployee( @PathVariable("Id")  Long Id ,@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, Id), HttpStatus.OK);


    }
    @DeleteMapping("{Id}")
    public ResponseEntity<String>  deleteEmployee( @PathVariable("Id")  Long Id ) {
        employeeService.deleteEmployee(Id);
        return new ResponseEntity<String>( "employee successfully deleted",HttpStatus.OK );
    }



    }
