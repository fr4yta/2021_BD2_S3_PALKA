package pl.polsl.telinf.s3.tickets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.telinf.s3.tickets.ticketModel.Ticket;
import pl.polsl.telinf.s3.tickets.ticketTypeModel.TicketType;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //TICKETS:

    @GetMapping(path = "/tickets")
    ResponseEntity<List<Ticket>> findAllTickets() {
        logger.info("Exposing all products");
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @GetMapping(path = "/tickets/{id}")
    ResponseEntity<Ticket> findTicketById(@PathVariable(name = "id") int id){
        return ResponseEntity.of(ticketService.findTicketById(id));
    }

    //TICKET_TYPES:

    @GetMapping(path = "/ticketTypes")
    ResponseEntity<List<TicketType>> findAllTicketTypes() {
        logger.info("Exposing all products");
        return ResponseEntity.ok(ticketService.findAllTicketTypes());
    }

    @GetMapping(path = "/ticketTypes/{id}")
    ResponseEntity<TicketType> findTicketTypeById(@PathVariable(name = "id") int id){
        return ResponseEntity.of(ticketService.findTicketTypeById(id));
    }
}
