package com.example.Gest_Tickets.Service;

import com.example.Gest_Tickets.Enum.NiveauUrgence;
import com.example.Gest_Tickets.Enum.Priorite;
import com.example.Gest_Tickets.Enum.Statut;
import com.example.Gest_Tickets.Modele.Ticket;
import com.example.Gest_Tickets.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket saveTicket(Ticket ticket) {
        // Assigne la date de création si le ticket est nouveau
        if (ticket.getId_ticket() == null) {
            ticket.setDateCreation(LocalDateTime.now());
        }
        // Assigne la date de modification à chaque sauvegarde
        ticket.setDateModification(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    // Méthode pour mettre à jour le statut d'un ticket
    public Ticket updateTicketStatut(Long id, Statut newStatut) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatut(newStatut);
            // Assigne la date de modification à chaque mise à jour de statut
            ticket.setDateModification(LocalDateTime.now());
            return ticketRepository.save(ticket);
        } else {
            throw new IllegalArgumentException("Ticket non trouvé avec l'ID: " + id);
        }
    }

    // Méthode pour mettre à jour la priorité et le niveau d'urgence d'un ticket
    public Ticket updateTicketPrioriteEtUrgence(Long id, Priorite newPriorite, NiveauUrgence newUrgence) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setPriorite(newPriorite);
            ticket.setNiveauUrgence(newUrgence);
            // Assigne la date de modification à chaque mise à jour de priorité et urgence
            ticket.setDateModification(LocalDateTime.now());
            return ticketRepository.save(ticket);
        } else {
            throw new IllegalArgumentException("Ticket non trouvé avec l'ID: " + id);
        }
    }
}
