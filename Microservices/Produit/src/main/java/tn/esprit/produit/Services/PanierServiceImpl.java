package tn.esprit.produit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.produit.Entity.Panier;
import tn.esprit.produit.Entity.Produit;
import tn.esprit.produit.Repository.PanierRepository;
import tn.esprit.produit.Repository.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PanierServiceImpl implements IPanierService {

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Panier addPanier(Panier panier) {
        // Vérification des produits existants
        for (Produit produit : panier.getProduits()) {
            Optional<Produit> optionalProduit = produitRepository.findById(produit.getId());

            if (optionalProduit.isPresent()) {
                Produit produitExistant = optionalProduit.get();
                // Si le produit n'est pas déjà dans le panier, on l'ajoute
                if (!panier.getProduits().contains(produitExistant)) {
                    panier.getProduits().add(produitExistant);
                }
            } else {
                throw new RuntimeException("Produit avec ID " + produit.getId() + " n'existe pas.");
            }
        }
        // Sauvegarde du panier avec les produits associés
        return panierRepository.save(panier);
    }
}