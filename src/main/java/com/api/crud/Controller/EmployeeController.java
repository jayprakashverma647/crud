package com.api.crud.Controller;

import com.api.crud.Entity.Employee;
import com.api.crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
@Autowired
    private EmployeeService service;

@PostMapping("/employee")
    public ResponseEntity<Employee>createEmployee(@Valid @RequestBody  Employee employee){
    Employee response = service.saveEmployee(employee);
    return  new ResponseEntity<>(response, HttpStatus.CREATED);
}

@GetMapping("/employee/{eid}")
public ResponseEntity<Employee>getEmployeeById(@PathVariable int eid){
    Employee response = service.getEmployee(eid);
    return new ResponseEntity<>(response,HttpStatus.FOUND);

 }

 @PutMapping("/employee/{eid}")
    public ResponseEntity<Employee>updateEmployeeById(@PathVariable int eid, @RequestBody Employee employee){
     Employee response = service.updateEmployee(eid, employee);
     return new ResponseEntity<>(response,HttpStatus.OK);
 }
 @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
     List<Employee> listAll = service.listAllEmployee();
     return  new ResponseEntity<>(listAll,HttpStatus.OK);
 }
 @DeleteMapping("/employee/{eid}")
    public ResponseEntity<Employee>deleteEmployeeById(@PathVariable int eid){
     Employee response = service.deleteEmployee(eid);
     return new ResponseEntity<>(response,HttpStatus.GONE);
 }
}
