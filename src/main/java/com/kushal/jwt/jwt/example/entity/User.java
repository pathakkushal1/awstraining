package com.kushal.jwt.jwt.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Data
public class User {

    @Id
    private Integer id;
    private String userName;
    private String number;
    private String password;
    private String role;
}
