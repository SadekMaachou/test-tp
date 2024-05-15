package com.esi.mspanier.controller;

import com.esi.mspanier.entity.Client;
import com.esi.mspanier.entity.Panier;
import com.esi.mspanier.repo.ClientRepository;
import com.esi.mspanier.repo.PanierRepository;
import com.esi.msproduit.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.esi.mspanier.AppConfig;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paniers")
public class PanierController {
    @Autowired
    private PanierRepository panierRepository;
    private ClientRepository clientRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{clientId}")
    public List<String> getProduitsPourClient(@PathVariable Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        Set<Panier> paniers = client.getPaniers();

        List<Produit> produits = paniers.stream()
                .flatMap(panier -> panier.getProduits().stream())
                .collect(Collectors.toList());

        String produitsUrl = "http://ms-produits/api/produits";
        List<Produit> produitsDetails = restTemplate.getForObject(produitsUrl, List.class);

        return produits.stream()
                .map(produit -> produitsDetails.stream()
                        .filter(p -> p.getId().equals(produit.getId()))
                        .map(Produit::getNom)
                        .findFirst()
                        .orElse("Produit inconnu"))
                .collect(Collectors.toList());
    }

    // Autres méthodes CRUD
}