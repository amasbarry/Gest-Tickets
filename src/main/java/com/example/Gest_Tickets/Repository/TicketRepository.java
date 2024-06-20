package com.example.Gest_Tickets.Repository;

import com.example.Gest_Tickets.Modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
