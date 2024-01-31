package com.example.spring_jwt_config.payload.User;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserResponse(
            String accessToken,
            String tokenType,
            Long expiresIn
) {
}

