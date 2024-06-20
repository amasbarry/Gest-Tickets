package com.example.Gest_Tickets.Service;

import com.example.Gest_Tickets.Modele.Utilisateur;
import com.example.Gest_Tickets.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    public List<Utilisateur> getUtilisateursByRole(String role) {
        return utilisateurRepository.findByRole(role);
    }

    public Optional<Utilisateur> getUtilisateurByNom(String nom) {
        return utilisateurRepository.findByNom(nom);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur existingUtilisateur = utilisateur.get();
            existingUtilisateur.setNom(utilisateurDetails.getNom());
            existingUtilisateur.setEmail(utilisateurDetails.getEmail());
            existingUtilisateur.setPassword(utilisateurDetails.getPassword());
            existingUtilisateur.setRole(utilisateurDetails.getRole());
            return utilisateurRepository.save(existingUtilisateur);
        }
        return null;
    }
}