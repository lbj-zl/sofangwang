package com.imooc.security;

import com.imooc.entity.User;
import com.imooc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    private final Md5PasswordEncoder encoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String userName = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("authenError");
        }

        if (encoder.isPasswordValid(user.getPassword(), password, user.getId())) {
            return new UsernamePasswordAuthenticationToken(user, null,
                    user.getAuthorities());
        }
        throw new BadCredentialsException("authenError");
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
