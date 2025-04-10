package com.example.CommandeService.Controller;


import com.example.CommandeService.entite.Facture;
import com.example.CommandeService.Service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    // Créer une facture
    @PostMapping
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        Facture newFacture = factureService.createFacture(facture);
        return new ResponseEntity<>(newFacture, HttpStatus.CREATED);
    }

    // Mettre à jour une facture
    @PutMapping("/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
        Facture updatedFacture = factureService.updateFacture(id, factureDetails);
        if (updatedFacture != null) {
            return new ResponseEntity<>(updatedFacture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une facture
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Récupérer une facture par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        Facture facture = factureService.getFactureById(id);
        if (facture != null) {
            return new ResponseEntity<>(facture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les factures
    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }
}

