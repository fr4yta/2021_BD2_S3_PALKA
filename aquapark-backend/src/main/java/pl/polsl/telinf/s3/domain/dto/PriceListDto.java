package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Data
public class PriceListDto {

    private String name;
    private Timestamp validFrom;
    private Timestamp validTo;
    private List<PriceItemDto> items;
}
