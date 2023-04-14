package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.GenerateHashPassword;
import com.example.SuperDuperDrive.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@Service
public class HashService {

    public final Logger logger = LoggerFactory.getLogger(HashService.class);

    private String getHashedValue(String data, String salt) {
        byte[] hashedValue = null;

        int iterCount = 12288;
        int derivedKeyLength = 256;
        KeySpec spec = new PBEKeySpec(data.toCharArray(), salt.getBytes(), iterCount, derivedKeyLength * 8);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hashedValue = factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }

        return Base64.getEncoder().encodeToString(hashedValue);
    }

    public GenerateHashPassword generateHashPassword(String password) {
        Random random = new Random();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashed = getHashedValue(password,encodedSalt);
        return new GenerateHashPassword(hashed,encodedSalt);
    }

    public boolean comparePassword(User user, String attemptPassword) {
        return user.getPassword().equals(getHashedValue(attemptPassword,user.getSalt()));
    }

}
