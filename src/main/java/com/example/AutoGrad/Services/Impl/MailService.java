package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Services.IMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailService implements IMailService {
    private static JavaMailSenderImpl mailSender = null;

    public MailService() {
        if (mailSender == null) {
            mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);

            mailSender.setUsername("trusha.shah123@gmail.com");
            mailSender.setPassword("sjfhxwljaczfeyoa");
            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");
        }
    }


    public void sendRegistrationMail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trusha.shah123@gmail.com");
        message.setTo(email);
        message.setSubject("Autograd: Activation Required!");
        message.setText("To activate your account, please click here: " + "http://localhost:8080/api/confirm-account?token=" + token);

        mailSender.send(message);
    }

    @Override
    public void sendActivationMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trusha.shah123@gmail.com");
        message.setTo(email);
        message.setSubject("Autograd welcomes you!");
        message.setText("Your account has been activated!");


        mailSender.send(message);
    }
}
