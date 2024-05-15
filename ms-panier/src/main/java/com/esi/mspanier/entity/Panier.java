package com.esi.mspanier.entity;

import com.esi.mspanier.entity.Client;
import com.esi.msproduit.entity.Produit;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Entity
public class Panier {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<Produit> produits;

    @ManyToMany
    @JoinTable(
            name = "panier_client",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Set<Produit> getProduits() {
        return produits;
    }

    // Getters, setters, constructeurs
}