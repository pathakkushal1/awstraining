package com.kushal.jwt.jwt.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Input {
    private String query;
    private Map<String, Object> param;
}
