package com.example.spring_jwt_config.common.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record EmptyJsonResponse() {
}
