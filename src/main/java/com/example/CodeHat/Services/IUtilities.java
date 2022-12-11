package com.example.CodeHat.Services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IUtilities {
    String generateHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean matchPassword(String userPassword, String dbPassword) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
