package com.example.spring_jwt_config;

import com.example.spring_jwt_config.utils.PasswordUtils;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.spring_jwt_config.properties")
@SecurityScheme(
        name = "bearerAuth",  // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
@OpenAPIDefinition(info = @Info(title = "E Certify SDK", version = "1.0",
        description = ""))
public class SpringJwtConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtConfigApplication.class, args);
    }

}
