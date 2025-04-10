package com.example.CommandeService.Service;

import com.example.CommandeService.entite.Commande;
import com.example.CommandeService.Repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Créer une nouvelle commande
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Mettre à jour une commande existante
    public Commande updateCommande(Long id, Commande commandeDetails) {
        Optional<Commande> existingCommande = commandeRepository.findById(id);
        if (existingCommande.isPresent()) {
            Commande commande = existingCommande.get();
            commande.setOrderNumber(commandeDetails.getOrderNumber());
            commande.setOrderDate(commandeDetails.getOrderDate());
            commande.setTotalAmount(commandeDetails.getTotalAmount());
            return commandeRepository.save(commande);
        }
        return null;  // Vous pouvez gérer l'exception si nécessaire
    }

    // Supprimer une commande par son ID
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    // Récupérer une commande par son ID
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);  // Gérer l'exception si nécessaire
    }

    // Récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}
