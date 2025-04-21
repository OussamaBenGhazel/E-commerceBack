package com.example.CommandeService.Controller;

import com.example.CommandeService.Service.CommandeService;
import com.example.CommandeService.entite.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")

public class CommandeController {

    @Autowired  // Utilisation de @Autowired pour l'injection par champ
    private CommandeService commandeService;

    @PostMapping("/create/{panierId}")
    public Commande createCommandeFromPanier(@PathVariable Long panierId) {
        return commandeService.createCommandeFromPanier(panierId);
    }

    @PostMapping("/create")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @GetMapping("/all")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @PutMapping("/update/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commandeDetails) {
        return commandeService.updateCommande(id, commandeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
