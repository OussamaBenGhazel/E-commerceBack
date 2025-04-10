package com.example.CommandeService.Service;


import com.example.CommandeService.entite.Facture;
import com.example.CommandeService.Repo.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    // Créer une nouvelle facture
    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    // Mettre à jour une facture existante
    public Facture updateFacture(Long id, Facture factureDetails) {
        Optional<Facture> existingFacture = factureRepository.findById(id);
        if (existingFacture.isPresent()) {
            Facture facture = existingFacture.get();
            facture.setMontantTotal(factureDetails.getMontantTotal());
            facture.setDateFacture(factureDetails.getDateFacture());
            facture.setStatus(factureDetails.getStatus());
            facture.setCommande(factureDetails.getCommande());
            return factureRepository.save(facture);
        }
        return null;  // Gérer l'exception si nécessaire
    }

    // Supprimer une facture
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    // Récupérer une facture par son ID
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElse(null);  // Gérer l'exception si nécessaire
    }

    // Récupérer toutes les factures
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
}

