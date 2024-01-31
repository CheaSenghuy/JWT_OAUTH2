package com.example.spring_jwt_config.payload.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest (    @NotBlank
                               @Size(max = 50)
                               String username,
                               @NotBlank
                               @Size(max = 150)
                               @JsonProperty("password")
                               String password) {

}
