package com.example.spring_jwt_config.controller.auth;


import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.payload.User.UserRequest;
import com.example.spring_jwt_config.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController extends RestApiController {

    private final AuthService authService;

    @PostMapping("/signup")
    public Object signup(@RequestBody @Valid UserRequest payload) throws Throwable {
        authService.signup(payload);
        return ok();
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid UserRequest payload) throws Throwable {
        return ok(authService.login(payload));
    }

    @GetMapping("/demo")
    public Object demo() throws Throwable {
        return ok("JJ");
    }
}
