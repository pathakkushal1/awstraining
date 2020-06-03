package com.kushal.jwt.jwt.example.repository;

import com.kushal.jwt.jwt.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUserName(String name);

}
