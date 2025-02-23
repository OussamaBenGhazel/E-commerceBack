package tn.esprit.produit.Services;

import org.springframework.stereotype.Service;
import tn.esprit.produit.Entity.Produit;

import java.util.List;

@Service
public interface IProduitService {

    Produit addProduit(Produit produit);
    void deleteProduit (Long id);
    List<Produit> getAllProduit();
    Produit updateProduit(Produit produit);
    Produit fingById(Long id);


}
