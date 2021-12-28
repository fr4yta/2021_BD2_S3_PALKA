package pl.polsl.telinf.s3.repository;

import pl.polsl.telinf.s3.domain.model.ticket.Ticket;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    List<Ticket> findAll();
    Optional<Ticket> findById(int id);
    Ticket save(@Valid Ticket entity);

}
