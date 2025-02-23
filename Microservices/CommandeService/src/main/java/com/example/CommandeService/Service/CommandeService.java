package com.example.CommandeService.Service;

import com.example.CommandeService.Repo.CommandeRepository;
import com.example.CommandeService.entite.Commande;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository repository;
    private final StreamBridge streamBridge;

    public CommandeService(CommandeRepository repository, StreamBridge streamBridge) {
        this.repository = repository;
        this.streamBridge = streamBridge;
    }

    public Commande addCommande(Commande commande) {
        commande.setOrderDate(LocalDateTime.now());
        Commande savedCommande = repository.save(commande);

        // Créer un message JSON pour l'événement
        String message = String.format("{\"orderId\": %d, \"orderNumber\": \"%s\", \"totalAmount\": %f}",
                savedCommande.getId(), savedCommande.getOrderNumber(), savedCommande.getTotalAmount());

        // Publier l'événement sur RabbitMQ
        streamBridge.send("notification-event-out", message);

        return savedCommande;
    }

    public List<Commande> getallCommandes() {
        return repository.findAll();
    }
}
