package com.esi.mspanier.repo;

import com.esi.mspanier.entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici
}