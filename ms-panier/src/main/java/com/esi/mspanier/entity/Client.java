package com.esi.mspanier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
public class Client {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToMany(mappedBy = "clients")
    private Set<Panier> paniers;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Set<Panier> getPaniers() {
        return paniers;
    }

    public String getNom() {
        return nom;
    }

    // Getters, setters, constructeurs
}