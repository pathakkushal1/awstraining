package com.kushal.jwt.jwt.example.controller;

import com.kushal.jwt.jwt.example.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/db/")
public class DBController {

   @GetMapping("/query")
   public ResponseEntity<Result<String>> query(){
       return new ResponseEntity<>(new Result<>(Arrays.asList("Request reached"),"Result is null for now"), HttpStatus.OK);
   }

    @PostMapping("/update")
    public ResponseEntity<Result<List>> update(@RequestBody Integer numbers[]){
        Stream<Integer> stream = Arrays.asList(numbers).stream();
        List number = stream.filter(a -> a%2==0).collect(Collectors.toList());
        System.out.println(number);
        return new ResponseEntity<>(new Result<>(Arrays.asList("Request reached"),number), HttpStatus.OK);
    }
}
