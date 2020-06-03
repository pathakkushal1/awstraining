package com.kushal.jwt.jwt.example.exception;

import com.kushal.jwt.jwt.example.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ExceptionHandler {
    public <T> Result<T> createException(String message, HttpStatus httpStatus){
        List<String> messgaes = Arrays.asList(message);
        return new Result(messgaes,new Exception(message));
    }
}
