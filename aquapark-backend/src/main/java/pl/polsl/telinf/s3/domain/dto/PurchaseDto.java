package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PurchaseDto {
    private int priceItemId;
    private Timestamp entryDate;
}
