package com.example.CommandeService.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO  {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
}
