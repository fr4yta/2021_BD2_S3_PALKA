package pl.polsl.telinf.s3.domain.model.priceList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.telinf.s3.domain.model.pass.Pass;
import pl.polsl.telinf.s3.domain.model.purchase.Purchase;
import pl.polsl.telinf.s3.domain.model.ticket.Ticket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "price_items_on_price_lists")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PriceItemOnPriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    @ManyToOne (targetEntity = PriceList.class)
    @JoinColumn(name = "price_lists_id", nullable = false)
    @JsonIgnore
    private PriceList priceList;

    @ManyToOne (targetEntity = PriceItemType.class)
    @JoinColumn(name = "price_item_type_id", nullable = false)
    private PriceItemType priceItemType;

    @ManyToOne (targetEntity = Ticket.class)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne (targetEntity = Pass.class)
    @JoinColumn(name = "pass_id", nullable = false)
    private Pass pass;

    @OneToMany (targetEntity = Purchase.class, cascade = CascadeType.ALL, mappedBy = "item")
    @JsonIgnore
    private Set<Purchase> purchasesItems = new HashSet<>();

}
