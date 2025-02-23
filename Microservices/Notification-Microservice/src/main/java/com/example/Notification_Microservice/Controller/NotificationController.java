package com.example.Notification_Microservice.Controller;

import com.example.Notification_Microservice.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody Map<String, String> notificationContent) {
        try {
            String message = notificationContent.get("message");
            if (message != null && !message.isEmpty()) {
                // Envoi du message via RabbitMQ et traitement
                notificationService.handleNotification(MessageBuilder.withPayload(message).build());
                return ResponseEntity.ok("Notification envoyée et email envoyé!");
            } else {
                return ResponseEntity.badRequest().body("Erreur : Le message est vide.");
            }
        } catch (Exception e) {
            // Retourner une erreur 500 avec le message d'exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur serveur : " + e.getMessage());
        }
    }
}
