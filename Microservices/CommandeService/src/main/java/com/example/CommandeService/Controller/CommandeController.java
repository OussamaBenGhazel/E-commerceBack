package com.example.CommandeService.Controller;

import com.example.CommandeService.Service.CommandeService;
import com.example.CommandeService.entite.Commande;
import com.example.ProduitServices.entite.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        Commande savedCommande = commandeService.addCommande(commande);
        return ResponseEntity.ok(savedCommande);
    }


    @GetMapping
    public List<Commande> getallCommandes() {
        return commandeService.getallCommandes();
    }
}

