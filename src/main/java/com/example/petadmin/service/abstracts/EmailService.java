package com.example.petadmin.service.abstracts;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendMail(SimpleMailMessage message);
}
