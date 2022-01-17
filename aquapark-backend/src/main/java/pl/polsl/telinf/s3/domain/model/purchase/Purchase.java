package pl.polsl.telinf.s3.domain.model.purchase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp purchaseDate;
    private Timestamp entryDate;

    @ManyToOne (targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne (targetEntity = PriceItemOnPriceList.class)
    @JoinColumn(name = "price_item_on_price_list_id", nullable = false)
    private PriceItemOnPriceList item;
}
