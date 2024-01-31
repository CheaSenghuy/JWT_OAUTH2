package com.example.spring_jwt_config.service.auth;

import com.example.spring_jwt_config.common.api.StatusCode;
import com.example.spring_jwt_config.components.security.UserAuthenticationProvider;
import com.example.spring_jwt_config.domain.role.Role;
import com.example.spring_jwt_config.domain.user.User;
import com.example.spring_jwt_config.domain.user.UserRepository;
import com.example.spring_jwt_config.exception.BusinessException;
import com.example.spring_jwt_config.payload.User.SecurityUser;
import com.example.spring_jwt_config.payload.User.UserRequest;
import com.example.spring_jwt_config.payload.User.UserResponse;
import com.example.spring_jwt_config.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationProvider authProvider;
    private final TokenService tokenService;


    @Override
    public Object login(UserRequest payload) throws Throwable {

        // Perform authentication
        Authentication authenticate = authProvider.authenticate(payload.username(), payload.password());

        SecurityUser securityUser = (SecurityUser) authenticate.getPrincipal();
        // Set the authenticated user in the SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        // Generate JWT token
        String token = tokenService.generateToken(securityUser);

        // Return the token in the response
        return new UserResponse(token, "Bearer", tokenService.getExpireIn());
    }

    @Override
    public void signup(UserRequest payload) throws Throwable {
        var findUser = userRepository.findUserByUsername(payload.username());
        if(findUser.isPresent()){
            throw new BusinessException(StatusCode.USER_ID_EXIST,"User alraedy exist");
        }
        String rawPassword;
        try {
            rawPassword = passwordEncoder.encode(PasswordUtils.decrypt(payload.password()));
        } catch (Exception e){
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

        var user = User.builder()
                .username(payload.username())
                .password(rawPassword)
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }

    public Object getEncodePassword(String password) throws Exception {
        return PasswordUtils.encrypt(password);
    }
}
