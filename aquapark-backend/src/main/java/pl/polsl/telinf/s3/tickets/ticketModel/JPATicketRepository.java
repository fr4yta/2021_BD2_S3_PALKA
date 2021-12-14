package pl.polsl.telinf.s3.tickets.ticketModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATicketRepository extends TicketRepository, JpaRepository<Ticket, Integer> {
}
