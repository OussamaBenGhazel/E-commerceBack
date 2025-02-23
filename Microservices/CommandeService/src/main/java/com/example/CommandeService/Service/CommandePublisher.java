package com.example.CommandeService.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Configuration
public class CommandePublisher {
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

    public void publish(String message) {
        messageQueue.offer(message);
    }

    @Bean
    public Supplier<String> sendCommande() {
        return () -> messageQueue.poll();
    }
}
