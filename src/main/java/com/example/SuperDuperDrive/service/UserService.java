package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateUserRequest;
import com.example.SuperDuperDrive.dto.GenerateHashPassword;
import com.example.SuperDuperDrive.dto.ExceptionResponse;
import com.example.SuperDuperDrive.entity.User;
import com.example.SuperDuperDrive.exception.UsernameExistsException;
import com.example.SuperDuperDrive.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public void createUser(CreateUserRequest createUserRequest) {
        Optional<User> user = userMapper.findByUsername(createUserRequest.getUsername().toUpperCase());

        if(user.isPresent()){
            throw new UsernameExistsException();
        }

        GenerateHashPassword Password = hashService.generateHashPassword(createUserRequest.getPassword());
        userMapper.create(new User(createUserRequest.getUsername(),Password.getSalt(),Password.getHashedPassword(),createUserRequest.getUsername(),createUserRequest.getLastname()));
    }


}
