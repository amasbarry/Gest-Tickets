package com.example.Gest_Tickets.Repository;
import com.example.Gest_Tickets.Modele.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

}
