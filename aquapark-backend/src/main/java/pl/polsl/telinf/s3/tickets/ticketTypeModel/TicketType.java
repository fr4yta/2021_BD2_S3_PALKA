package pl.polsl.telinf.s3.tickets.ticketTypeModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.telinf.s3.tickets.ticketModel.Ticket;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ticket_types")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @OneToMany (targetEntity = Ticket.class, cascade = CascadeType.ALL, mappedBy = "ticketType", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ticket> tickets;

}
