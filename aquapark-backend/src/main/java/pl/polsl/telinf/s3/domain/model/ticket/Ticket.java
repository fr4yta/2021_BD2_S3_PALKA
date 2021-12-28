package pl.polsl.telinf.s3.domain.model.ticket;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne (targetEntity = TicketType.class)
    @JoinColumn(name = "ticket_type", nullable = false)
    private TicketType ticketType;

}
