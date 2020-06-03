package com.kushal.jwt.jwt.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class DBModel<T> {
    String message;
    String status;
    T obj;
}
