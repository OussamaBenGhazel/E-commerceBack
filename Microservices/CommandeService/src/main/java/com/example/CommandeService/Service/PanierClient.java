package com.example.CommandeService.Service;

import com.example.CommandeService.entite.PanierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "Produit")
public interface PanierClient {

    @GetMapping("/panier//getPanier/{id}")
    PanierDTO getPanierById(@PathVariable("id") Long id);

    @PostMapping("/panier/addPanier")
    PanierDTO createPanier(@RequestBody PanierDTO panier);
}

