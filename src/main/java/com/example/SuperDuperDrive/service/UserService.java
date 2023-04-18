package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateUserRequest;
import com.example.SuperDuperDrive.dto.GenerateHashPassword;
import com.example.SuperDuperDrive.dto.Response;
import com.example.SuperDuperDrive.entity.User;
import com.example.SuperDuperDrive.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public Response<Boolean> createUser(CreateUserRequest createUserRequest) {
        Optional<User> user = userMapper.findByUsername(createUserRequest.getUsername().toUpperCase());

        if(user.isPresent()){
            return new Response<Boolean>(false,"username already exist");
        }

        GenerateHashPassword Password = hashService.generateHashPassword(createUserRequest.getPassword());
        userMapper.create(new User(createUserRequest.getUsername(),Password.getSalt(),Password.getHashedPassword(),createUserRequest.getUsername(),createUserRequest.getLastname()));
        return new Response<Boolean>(true);
    }


}
