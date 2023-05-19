package com.example.petadmin.service.impl;

import com.example.petadmin.service.abstracts.EmailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageImpl extends SimpleMailMessage implements EmailMessage {
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    public SimpleMailMessage getMailMessage(String to, String from, String subject, String text) {
        mailMessage.setTo(to);
        mailMessage.setFrom(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        return mailMessage;
    }
}
