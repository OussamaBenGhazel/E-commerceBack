package tn.esprit.produit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.produit.Entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit , Long> {
}
