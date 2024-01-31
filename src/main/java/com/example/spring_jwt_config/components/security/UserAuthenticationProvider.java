package com.example.spring_jwt_config.components.security;

import com.example.spring_jwt_config.common.api.StatusCode;
import com.example.spring_jwt_config.exception.BusinessException;
import com.example.spring_jwt_config.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserAuthenticationProvider {
    private final AuthenticationManager authenticationManager;

    public UserAuthenticationProvider(@Qualifier("userAuthProvider")AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    //Not having access to the user’s password
    public Authentication authenticate(String username, String password){
        try {
            var rawPwd = PasswordUtils.decrypt(password);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, rawPwd));
        }
        catch (UsernameNotFoundException ex){
            throw new BusinessException(StatusCode.USER_NOT_FOUND, ex.getMessage());
        } catch (BadCredentialsException e) {
            throw new BusinessException(StatusCode.BAD_CREDENTIALS, e);
        } catch (DisabledException e){
            throw new BusinessException(StatusCode.USER_DISABLED);
        }
        catch (LockedException e) {
            throw new BusinessException(StatusCode.USER_LOCKED);
        }
        catch (Exception e) {
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

    }
}
