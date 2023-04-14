package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.entity.User;
import com.example.SuperDuperDrive.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthenticationProvider {

    private final UserMapper userMapper;
    private final HashService hashService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<User> user = userMapper.findByUsername(authentication.getName().toUpperCase());
        if (user.isEmpty() || !hashService.comparePassword(user.get(), authentication.getCredentials().toString())) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(user.get(),authentication.getCredentials(),null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
