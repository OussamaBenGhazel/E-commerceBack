package com.example.Notification_Microservice.Service;

import com.example.Notification_Microservice.Service.EmailService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(MyProcessor.class)
public class NotificationService {

    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    @ServiceActivator(inputChannel = MyProcessor.INPUT)
    public void handleNotification(Message<String> message) {
        String notificationContent = message.getPayload();
        System.out.println("Nouvelle notification reçue : " + notificationContent);

        // Logique pour envoyer un email (remplace l'email par celui du destinataire réel)
        String emailBody = "Vous avez une nouvelle notification : " + notificationContent;
        emailService.sendEmail("wassimhajji11@gmail.com", "Nouvelle Notification", emailBody);
    }
}
