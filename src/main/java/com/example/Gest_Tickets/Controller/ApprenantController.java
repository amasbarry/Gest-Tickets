package com.example.Gest_Tickets.Controller;

import com.example.Gest_Tickets.Modele.Apprenant;
import com.example.Gest_Tickets.Service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {

    private final ApprenantService apprenantService;

    @Autowired
    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @GetMapping
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        List<Apprenant> apprenants = apprenantService.getAllApprenants();
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        Apprenant apprenant = apprenantService.getApprenantById(id);
        if (apprenant != null) {
            return ResponseEntity.ok(apprenant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        Apprenant createdApprenant = apprenantService.saveApprenant(apprenant);
        return new ResponseEntity<>(createdApprenant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        Apprenant existingApprenant = apprenantService.getApprenantById(id);

        if (existingApprenant != null) {
            existingApprenant.setNom(apprenantDetails.getNom());
            existingApprenant.setEmail(apprenantDetails.getEmail());
            existingApprenant.setTelephone(apprenantDetails.getTelephone());

            Apprenant updatedApprenant = apprenantService.saveApprenant(existingApprenant);
            return ResponseEntity.ok(updatedApprenant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }
}
