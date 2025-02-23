package com.example.Notification_Microservice.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("azizbenabeda123@gmail.com");  // Ton adresse email
        message.setTo(to);  // Adresse du destinataire
        message.setSubject(subject);  // Sujet de l'email
        message.setText(text);  // Corps de l'email

        emailSender.send(message);  // Envoie l'email
    }
}
