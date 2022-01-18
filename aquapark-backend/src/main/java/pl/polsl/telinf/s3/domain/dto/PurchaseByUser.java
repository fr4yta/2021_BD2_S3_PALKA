package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;

import java.sql.Timestamp;

@Data
public class PurchaseByUser {
    int id;
    private Timestamp purchaseDate;
    private Timestamp entryDate;
    private PriceItemOnPriceList priceItem;
}
