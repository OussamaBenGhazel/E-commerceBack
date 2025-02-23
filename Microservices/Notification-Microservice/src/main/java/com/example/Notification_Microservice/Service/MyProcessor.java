package com.example.Notification_Microservice.Service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MyProcessor {
    String INPUT = "notification-event";

    @Input(INPUT)
    MessageChannel input();
}
