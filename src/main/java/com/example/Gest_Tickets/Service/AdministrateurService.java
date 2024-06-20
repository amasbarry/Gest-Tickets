package com.example.Gest_Tickets.Service;

import com.example.Gest_Tickets.Modele.Administrateur;
import com.example.Gest_Tickets.Repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {

    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Administrateur getAdministrateurById(Long id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    public Administrateur saveAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public Administrateur updateAdministrateur(Long id, Administrateur administrateurDetails) {
        Optional<Administrateur> optionalAdministrateur = administrateurRepository.findById(id);

        if (optionalAdministrateur.isPresent()) {
            Administrateur existingAdministrateur = optionalAdministrateur.get();
            existingAdministrateur.setNom(administrateurDetails.getNom());
            existingAdministrateur.setEmail(administrateurDetails.getEmail());

            return administrateurRepository.save(existingAdministrateur);
        }
        return null;
    }

    public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }
}
