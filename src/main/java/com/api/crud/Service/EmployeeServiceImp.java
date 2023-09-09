package com.api.crud.Service;

import com.api.crud.Entity.Employee;
import com.api.crud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepository repo;
    @Override
    public Employee saveEmployee(Employee employee) {

        return repo.save(employee);
    }

    @Override
    public Employee getEmployee(int eid) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
          return  byId.get();
        }

        return null;
    }

    @Override
    public Employee updateEmployee(int eid, Employee employee) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
            employee.setEid(eid);
            return repo.save(employee);
        }

        return null;
    }

    @Override
    public List<Employee> listAllEmployee() {
        List<Employee> all = repo.findAll();
        return all ;
    }

    @Override
    public Employee deleteEmployee(int eid) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
            repo.deleteById(eid);
            return byId.get();
        }
        return null;

    }
}
