package com.example.Gest_Tickets.Controller;

import com.example.Gest_Tickets.Enum.NiveauUrgence;
import com.example.Gest_Tickets.Enum.Priorite;
import com.example.Gest_Tickets.Enum.Statut;
import com.example.Gest_Tickets.Modele.Ticket;
import com.example.Gest_Tickets.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        ticketDetails.setId_ticket(id); // Assure l'ID correspond à celui dans l'URL
        Ticket updatedTicket = ticketService.saveTicket(ticketDetails);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<Ticket> updateTicketStatut(@PathVariable Long id, @RequestParam Statut statut) {
        try {
            Ticket updatedTicket = ticketService.updateTicketStatut(id, statut);
            return ResponseEntity.ok(updatedTicket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/priorite-urgence")
    public ResponseEntity<Ticket> updateTicketPrioriteEtUrgence(@PathVariable Long id,
                                                                @RequestParam Priorite priorite,
                                                                @RequestParam NiveauUrgence urgence) {
        try {
            Ticket updatedTicket = ticketService.updateTicketPrioriteEtUrgence(id, priorite, urgence);
            return ResponseEntity.ok(updatedTicket);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
