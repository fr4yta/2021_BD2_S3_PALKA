package pl.polsl.telinf.s3.repository;

import pl.polsl.telinf.s3.domain.model.ticket.TicketType;

import java.util.List;
import java.util.Optional;

public interface TicketTypeRepository {
    List<TicketType> findAll();
    Optional<TicketType> findById(int id);
    TicketType save(TicketType entity);
}
