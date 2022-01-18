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
import java.util.Set;

@Entity
@Table(name = "purchases", indexes = {
        @Index(name = "idx_purchase_price_item_id", columnList = "price_item_id")
})
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

    @ManyToOne(targetEntity = PriceItemOnPriceList.class)
    @JoinColumn(name = "price_item_id", referencedColumnName = "id", nullable = false)
    @NotFound (action=NotFoundAction.IGNORE)
    private PriceItemOnPriceList item;
}
