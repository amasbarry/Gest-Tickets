package com.example.Gest_Tickets.Repository;

import com.example.Gest_Tickets.Modele.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
