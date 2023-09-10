package com.api.crud.Service;

import com.api.crud.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    
    public Employee getEmployee(int eid);
    public Employee updateEmployee(int eid,Employee employee);
    public List<Employee> listAllEmployee();
    public Employee deleteEmployee(int eid);

}
