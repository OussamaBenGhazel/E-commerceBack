package com.example.CommandeService.entite;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Factures")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double montantTotal;  // Montant total de la facture

    @Column(nullable = false)
    private LocalDateTime dateFacture;  // Date de la facturation

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusFacture status;  // Statut de la facture (par exemple, payé, en attente)

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;  // La commande associée à la facture

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public LocalDateTime getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDateTime dateFacture) {
        this.dateFacture = dateFacture;
    }

    public StatusFacture getStatus() {
        return status;
    }

    public void setStatus(StatusFacture status) {
        this.status = status;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}

