package pl.polsl.telinf.s3.service;

import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemType;
import pl.polsl.telinf.s3.domain.model.priceList.PriceList;
import pl.polsl.telinf.s3.repository.jpa.JPAPriceItemOnPriceListRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAPriceItemTypeRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAPriceListRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class PriceListService {
    private JPAPriceItemOnPriceListRepository priceItemOnPriceListRepository;
    private JPAPriceItemTypeRepository priceItemTypeRepository;
    private JPAPriceListRepository priceListRepository;

    PriceListService(JPAPriceItemOnPriceListRepository priceItemOnPriceListRepository,
                     JPAPriceItemTypeRepository priceItemTypeRepository, JPAPriceListRepository priceListRepository) {
        this.priceItemOnPriceListRepository = priceItemOnPriceListRepository;
        this.priceItemTypeRepository = priceItemTypeRepository;
        this.priceListRepository = priceListRepository;
    }

    public PriceList findActivePriceList(){
        return priceListRepository.findAll().stream().filter(list -> list.getValidFrom().before(Timestamp.from(Instant.now())))
                .filter(list -> list.getValidTo().after(Timestamp.from(Instant.now())))
                .findAny().orElse(null);
    }

    public List<PriceItemOnPriceList> findActualPriceItems(){
        PriceList actualPriceList = this.findActivePriceList();
        return priceItemOnPriceListRepository.findAllByPriceListName(actualPriceList.getName());
    }

    public List<PriceList> findAllPriceLists(){
        return priceListRepository.findAll();
    }

    public List<PriceItemType> findAllPriceItemTypes() {
        return priceItemTypeRepository.findAll();
    }

    public PriceList addNewPriceList(PriceList toCreate) {
        return priceListRepository.save(toCreate);
    }
}
