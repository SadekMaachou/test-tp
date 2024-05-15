package com.esi.msproduit.controller;

import com.esi.msproduit.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.esi.msproduit.repo.ProduitRepository;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Autres méthodes CRUD
}