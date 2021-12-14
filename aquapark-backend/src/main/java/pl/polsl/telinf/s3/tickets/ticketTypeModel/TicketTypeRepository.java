package pl.polsl.telinf.s3.tickets.ticketTypeModel;

import java.util.List;
import java.util.Optional;

public interface TicketTypeRepository {
    List<TicketType> findAll();
    Optional<TicketType> findById(int id);
    TicketType save(TicketType entity);
}
