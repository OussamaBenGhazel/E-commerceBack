package tn.esprit.produit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.produit.Entity.Produit;
import tn.esprit.produit.Repository.ProduitRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    ProduitRepository pr;
    @Override
    public Produit addProduit(Produit produit) {
        return pr.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        pr.deleteById(id);

    }

    @Override
    public List<Produit> getAllProduit() {
        return pr.findAll();
    }
    @Override
    public Produit updateProduit(Produit produit) {
        return pr.save(produit);
    }
    @Override
    public Produit fingById(Long id) {
        return pr.findById(id).get();
    }
}
