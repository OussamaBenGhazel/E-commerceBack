package com.example.CommandeService.Repo;

import com.example.CommandeService.entite.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    // Vous pouvez ajouter des méthodes de recherche spécifiques ici si nécessaire
}