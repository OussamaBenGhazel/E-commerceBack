package com.example.CommandeService.Controller;

import com.example.CommandeService.entite.Commande;
import com.example.CommandeService.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Créer une commande
    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande newCommande = commandeService.createCommande(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

    // Mettre à jour une commande
    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
        Commande updatedCommande = commandeService.updateCommande(id, commandeDetails);
        if (updatedCommande != null) {
            return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Récupérer une commande par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande != null) {
            return new ResponseEntity<>(commande, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }
}
