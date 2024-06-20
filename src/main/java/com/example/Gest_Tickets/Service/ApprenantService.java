package com.example.Gest_Tickets.Service;
import com.example.Gest_Tickets.Modele.Apprenant;
import com.example.Gest_Tickets.Repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantService {

    private final ApprenantRepository apprenantRepository;

    @Autowired
    public ApprenantService(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    public Apprenant getApprenantById(Long id) {
        return apprenantRepository.findById(id).orElse(null);
    }

    public Apprenant saveApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }
}
