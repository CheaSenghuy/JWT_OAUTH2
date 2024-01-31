package com.example.spring_jwt_config.service.auth;

import com.example.spring_jwt_config.payload.User.UserRequest;
import org.springframework.stereotype.Service;


public interface AuthService {
    Object login(UserRequest payload) throws Throwable;
    void signup(UserRequest payload) throws Throwable;
    Object getEncodePassword(String payload) throws Throwable;
}
