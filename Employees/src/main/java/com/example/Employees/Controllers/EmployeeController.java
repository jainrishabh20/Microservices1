package com.example.Employees.Controllers;

import com.example.Employees.Dao.EmployeeDao;
import com.example.Employees.Models.Employee;
import com.example.Employees.Response.EmployeeResponse;
import com.example.Employees.Services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") Integer id){
       EmployeeResponse employeeResponse= this.employeeService.getEmployeeDetails(id);
       return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
