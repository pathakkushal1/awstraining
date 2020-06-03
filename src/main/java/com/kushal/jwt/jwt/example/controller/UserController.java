package com.kushal.jwt.jwt.example.controller;

import com.kushal.jwt.jwt.example.entity.Input;
import com.kushal.jwt.jwt.example.entity.Result;
import com.kushal.jwt.jwt.example.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    DBService dbService;

    @GetMapping("/")
    public String welcomePage() {
        return "Welcome to the Kushal world!";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Welcome to the Home!";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/query")
    public ResponseEntity<Result<List<Map<String,Object>>>> query(@RequestBody Input input) throws InterruptedException {
        return dbService.query(input.getQuery(),input.getParam());
    }

    @PutMapping("/update")
    public ResponseEntity<Result<Integer>> update(@RequestBody Input input) {
        return dbService.update(input.getQuery(),input.getParam());
    }

    @PostMapping("/numUpdate")
    public ResponseEntity<Result<List>> update(@RequestBody Integer[] numbers) {
        System.out.println(numbers);
        Stream<Integer> stream = Arrays.asList(numbers).stream();
        List<Integer> number = stream.filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(number);
        return new ResponseEntity<>(new Result<>(Arrays.asList("Request reached"), number), HttpStatus.OK);
    }
}
