package tn.esprit.produit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.produit.Entity.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
}
