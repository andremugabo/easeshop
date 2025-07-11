package com.ma.codinglab.shopease.core.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail, String verificationLink){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Verify Your Account - ShopEase");
        message.setText("Click the following link to verify your email:\n\n" + verificationLink);
        mailSender.send(message);
    }
}
