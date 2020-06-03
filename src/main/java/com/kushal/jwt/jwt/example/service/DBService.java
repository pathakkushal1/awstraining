package com.kushal.jwt.jwt.example.service;

import com.kushal.jwt.jwt.example.config.ServiceProperties;
import com.kushal.jwt.jwt.example.entity.Result;
import com.kushal.jwt.jwt.example.exception.ExceptionHandler;
import com.kushal.jwt.jwt.example.repository.DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DBService {

    @Autowired
    ExceptionHandler exceptionHandler;

    @Autowired
    DBRepository dbRepository;

    @Autowired
    ServiceProperties serviceProperties;


    public ResponseEntity<Result<List<Map<String,Object>>>> query(String query, Map<String, Object> param) {
        try{
            List<Map<String,Object>> output = dbRepository.query(query,param);
            return new ResponseEntity<>(new Result(Arrays.asList("Success"),output),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(exceptionHandler.createException(ex.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
        }




    }

    public ResponseEntity<Result<Integer>> update(String query, Map<String, Object> param) {
        try{
            Integer output = dbRepository.update(query,param);
            return new ResponseEntity<>(new Result(Arrays.asList("Success"),output),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(exceptionHandler.createException(ex.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
        }
    }
}
