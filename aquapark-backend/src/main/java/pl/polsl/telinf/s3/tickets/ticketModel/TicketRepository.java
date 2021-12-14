package pl.polsl.telinf.s3.tickets.ticketModel;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    List<Ticket> findAll();
    Optional<Ticket> findById(int id);
    Ticket save(Ticket entity);

}
