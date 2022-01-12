package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;

@Data
public class PriceItemDto {
    private double price;
    private int priceListId;
    private int priceItemTypeId;
    private int ticketId;
    private int passId;
}
