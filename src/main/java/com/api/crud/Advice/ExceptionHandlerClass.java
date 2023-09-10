package com.api.crud.Advice;

import com.api.crud.Excepiton.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, String>> hanledEmployeeNotFoundById(EmployeeNotFoundException exception) {
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("Massage", exception.getLocalizedMessage());
        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException mex) {

        Map<String, String> msgError = new HashMap<>();
        mex.getAllErrors().forEach(e -> msgError.put("errorMsg", e.getDefaultMessage()));
        return new ResponseEntity<>(msgError, HttpStatus.BAD_REQUEST);
    }
}
