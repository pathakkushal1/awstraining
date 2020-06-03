package com.kushal.jwt.jwt.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("application")
public class ServiceProperties {
    private String url;
    private String password;
    private String username;
}
