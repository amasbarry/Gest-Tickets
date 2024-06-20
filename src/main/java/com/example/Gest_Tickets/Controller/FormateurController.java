package com.example.Gest_Tickets.Controller;

import com.example.Gest_Tickets.Modele.Formateur;
import com.example.Gest_Tickets.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    private final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        List<Formateur> formateurs = formateurService.getAllFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable Long id) {
        Formateur formateur = formateurService.getFormateurById(id);
        if (formateur != null) {
            return ResponseEntity.ok(formateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur createdFormateur = formateurService.saveFormateur(formateur);
        return new ResponseEntity<>(createdFormateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails) {
        Formateur existingFormateur = formateurService.getFormateurById(id);
        if (existingFormateur != null) {
            existingFormateur.setNom(formateurDetails.getNom());
            existingFormateur.setEmail(formateurDetails.getEmail());
            existingFormateur.setSpecialisation(formateurDetails.getSpecialisation());

            Formateur updatedFormateur = formateurService.saveFormateur(existingFormateur);
            return ResponseEntity.ok(updatedFormateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        formateurService.deleteFormateur(id);
        return ResponseEntity.noContent().build();
    }
}
