package com.example.CommandeService.Service;

import com.example.CommandeService.Repo.CommandeRepository;
import com.example.CommandeService.entite.Commande;
import com.example.CommandeService.entite.PanierDTO;
import com.example.CommandeService.entite.ProduitDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private PanierClient panierClient;

    // ✅ Créer une commande à partir d’un panier récupéré via Feign
    public Commande createCommandeFromPanier(Long panierId) {
        // Récupération du panier via Feign
        PanierDTO panier = panierClient.getPanierById(panierId);

        if (panier == null || panier.getProduits().isEmpty()) {
            throw new RuntimeException("Le panier est vide ou introuvable");
        }

        // Calcul du montant total de la commande à partir des produits dans le panier
        double totalAmount = panier.getProduits().stream()
                .mapToDouble(ProduitDTO::getPrice)
                .sum();

        // Création de la commande
        Commande commande = new Commande();
        commande.setOrderNumber("CMD-" + System.currentTimeMillis());
        commande.setOrderDate(LocalDateTime.now());
        commande.setTotalAmount(totalAmount);

        // Optionnel : si vous voulez associer des informations supplémentaires sur les produits dans la commande, vous pouvez ajouter cette logique ici.

        // Sauvegarde de la commande
        return commandeRepository.save(commande);
    }

    // ✅ Créer une commande manuellement (non lié au panier)
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // ✅ Mettre à jour une commande existante
    public Commande updateCommande(Long id, Commande commandeDetails) {
        Optional<Commande> existingCommande = commandeRepository.findById(id);
        if (existingCommande.isPresent()) {
            Commande commande = existingCommande.get();
            commande.setOrderNumber(commandeDetails.getOrderNumber());
            commande.setOrderDate(commandeDetails.getOrderDate());
            commande.setTotalAmount(commandeDetails.getTotalAmount());
            return commandeRepository.save(commande);
        }
        return null;
    }

    // ✅ Supprimer une commande par ID
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    // ✅ Récupérer une commande par ID
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    // ✅ Récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}
