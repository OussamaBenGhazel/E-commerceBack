package com.example.CommandeService.entite;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDTO  {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<ProduitDTO> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitDTO> produits) {
        this.produits = produits;
    }

    private Long id;
    private String owner;
    private List<ProduitDTO> produits = new ArrayList<>();

}
