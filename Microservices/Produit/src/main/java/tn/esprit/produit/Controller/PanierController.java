package tn.esprit.produit.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.produit.Entity.Panier;
import tn.esprit.produit.Services.IPanierService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/panier")
public class PanierController {

  private final IPanierService ps;

  @PostMapping("/addPanier")
    public Panier addPanier (@RequestBody Panier panier){
      Panier p=ps.addPanier(panier);
      return p;
  }


  @GetMapping("/getPanier/{id}")
  public Panier getPanierById(@PathVariable Long id) {
    return ps.getPanierById(id);
  }


}
