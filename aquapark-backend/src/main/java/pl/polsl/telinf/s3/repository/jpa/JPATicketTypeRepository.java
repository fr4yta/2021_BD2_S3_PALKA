package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.repository.TicketTypeRepository;
import pl.polsl.telinf.s3.domain.model.ticket.TicketType;

@Repository
public interface JPATicketTypeRepository extends TicketTypeRepository, JpaRepository<TicketType, Integer> {
}
