package pl.polsl.telinf.s3.tickets;

import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.tickets.ticketModel.Ticket;
import pl.polsl.telinf.s3.tickets.ticketModel.TicketRepository;
import pl.polsl.telinf.s3.tickets.ticketTypeModel.TicketType;
import pl.polsl.telinf.s3.tickets.ticketTypeModel.TicketTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private TicketTypeRepository ticketTypeRepository;

    public TicketService(TicketRepository ticketRepository, TicketTypeRepository ticketTypeRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findTicketById(int id) {
        return ticketRepository.findById(id);
    }

    public List<TicketType> findAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    public Optional<TicketType> findTicketTypeById(int id) {
        return ticketTypeRepository.findById(id);
    }
}
