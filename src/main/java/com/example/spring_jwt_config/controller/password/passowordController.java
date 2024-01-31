package com.example.spring_jwt_config.controller.password;

import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/password")
@RequiredArgsConstructor
public class passowordController extends RestApiController {
    private final AuthService authService;
    @PostMapping
    public Object getPasswordEncrpt (@RequestBody String payload) throws Throwable {
        return ok(authService.getEncodePassword(payload));
    }
}
