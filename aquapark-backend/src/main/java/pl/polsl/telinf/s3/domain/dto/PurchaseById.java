package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.user.User;

import java.sql.Timestamp;

@Data
 public class PurchaseById {
    int id;
    private Timestamp purchaseDate;
    private Timestamp entryDate;
    private User user;
    private PriceItemOnPriceList priceItem;
}
