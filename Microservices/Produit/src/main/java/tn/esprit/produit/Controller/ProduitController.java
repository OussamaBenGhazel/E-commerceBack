package tn.esprit.produit.Controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tn.esprit.produit.Entity.Produit;
import tn.esprit.produit.Services.IProduitService;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/produit")
public class ProduitController {



    @Autowired
    @Qualifier("produitServiceImpl")
    private final IProduitService ps;

    @PostMapping("/addProduit")
    public Produit addProduit(@RequestBody Produit produit){
        Produit p=ps.addProduit(produit);
        return p;

    }


    @PutMapping("/modifier")
    public Produit updateProduit(@RequestBody Produit produit){
        Produit p=ps.updateProduit(produit);
        return p;
    }

    @DeleteMapping("/delete/{produitid}")
    public void deleteProduit(@PathVariable("produitid")Long id){
        ps.deleteProduit(id);
    }


    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return ps.getAllProduit();
    }






















}
