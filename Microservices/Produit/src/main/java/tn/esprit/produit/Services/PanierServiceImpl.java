package tn.esprit.produit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.produit.Entity.Panier;
import tn.esprit.produit.Entity.Produit;
import tn.esprit.produit.Repository.PanierRepository;
import tn.esprit.produit.Repository.ProduitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PanierServiceImpl implements IPanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    @Transactional
    public Panier addPanier(Panier panier) {
        List<Produit> produitsValides = new ArrayList<>();

        for (Produit produit : panier.getProduits()) {
            Optional<Produit> optionalProduit = produitRepository.findById(produit.getId());
            if (optionalProduit.isPresent()) {
                Produit produitExistant = optionalProduit.get();
                if (!produitsValides.contains(produitExistant)) {
                    produitsValides.add(produitExistant);
                }
            } else {
                throw new RuntimeException("Produit avec ID " + produit.getId() + " n'existe pas.");
            }
        }

        // Évite les doublons : on écrase la liste initiale
        panier.setProduits(produitsValides);

        return panierRepository.save(panier);
    }



    @Override
    public Panier getPanierById(Long id) {
        return panierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Panier avec ID " + id + " non trouvé."));
    }

}