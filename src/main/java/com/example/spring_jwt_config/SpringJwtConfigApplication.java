package com.example.spring_jwt_config;

import com.example.spring_jwt_config.utils.PasswordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.spring_jwt_config.properties")
public class SpringJwtConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtConfigApplication.class, args);
    }

}
