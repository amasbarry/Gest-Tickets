package com.example.Gest_Tickets.Repository;

import com.example.Gest_Tickets.Modele.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
}

