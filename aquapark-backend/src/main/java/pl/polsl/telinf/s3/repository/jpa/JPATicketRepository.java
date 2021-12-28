package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.repository.TicketRepository;
import pl.polsl.telinf.s3.domain.model.ticket.Ticket;

@Repository
public interface JPATicketRepository extends TicketRepository, JpaRepository<Ticket, Integer> {
}
