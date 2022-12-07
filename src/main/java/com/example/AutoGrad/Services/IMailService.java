package com.example.AutoGrad.Services;

public interface IMailService {

    void sendRegistrationMail(String email, String token);

    void sendActivationMail(String user_email);
}
