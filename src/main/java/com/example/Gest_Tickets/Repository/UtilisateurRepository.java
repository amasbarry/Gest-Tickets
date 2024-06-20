package com.example.Gest_Tickets.Repository;

import com.example.Gest_Tickets.Modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Méthode pour trouver un utilisateur par son email
    Optional<Utilisateur> findByEmail(String email);

    // Méthode pour vérifier si un email existe déjà
    boolean existsByEmail(String email);

    // Méthode pour trouver des utilisateurs par leur rôle
    List<Utilisateur> findByRole(String role);

    // Méthode pour trouver un utilisateur par son nom
    Optional<Utilisateur> findByNom(String nom);
}