package com.api.crud.Excepiton;


public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String msg) {
     super(msg);
    }
}
