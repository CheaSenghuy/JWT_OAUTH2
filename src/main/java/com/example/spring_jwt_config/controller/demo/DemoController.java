package com.example.spring_jwt_config.controller.demo;

import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/demo")
@RequiredArgsConstructor
public class DemoController extends RestApiController {
    @GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

}
