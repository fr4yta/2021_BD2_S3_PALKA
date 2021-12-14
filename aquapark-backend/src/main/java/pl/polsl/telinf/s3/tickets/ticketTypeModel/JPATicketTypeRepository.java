package pl.polsl.telinf.s3.tickets.ticketTypeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATicketTypeRepository extends TicketTypeRepository, JpaRepository<TicketType, Integer> {
}
