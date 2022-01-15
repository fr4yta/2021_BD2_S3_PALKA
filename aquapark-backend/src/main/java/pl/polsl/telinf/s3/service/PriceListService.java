package pl.polsl.telinf.s3.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.dto.PriceItemDto;
import pl.polsl.telinf.s3.domain.dto.exception.DataNotFoundException;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemType;
import pl.polsl.telinf.s3.domain.model.priceList.PriceList;
import pl.polsl.telinf.s3.repository.jpa.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceListService {
    private JPAPriceItemOnPriceListRepository priceItemOnPriceListRepository;
    private JPAPriceItemTypeRepository priceItemTypeRepository;
    private JPAPriceListRepository priceListRepository;
    private JPAPassRepository passRepository;
    private JPATicketRepository ticketRepository;

    PriceListService(JPAPriceItemOnPriceListRepository priceItemOnPriceListRepository,
                     JPAPriceItemTypeRepository priceItemTypeRepository, JPAPriceListRepository priceListRepository, JPAPassRepository passRepository, JPATicketRepository ticketRepository) {
        this.priceItemOnPriceListRepository = priceItemOnPriceListRepository;
        this.priceItemTypeRepository = priceItemTypeRepository;
        this.priceListRepository = priceListRepository;
        this.passRepository = passRepository;
        this.ticketRepository = ticketRepository;
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

    public List<PriceItemOnPriceList> findAllPriceItems() {
        priceItemOnPriceListRepository.findAll().forEach(item -> System.out.println(item.getId()));
        return priceItemOnPriceListRepository.findAll();

    }

    public PriceList addNewPriceList(String name, Timestamp validFrom, Timestamp validTo) {
        PriceList toCreate = new PriceList();
        toCreate.setValidFrom(validFrom);
        toCreate.setName(name);
        toCreate.setValidTo(validTo);
        return priceListRepository.save(toCreate);
    }

    public List<PriceItemOnPriceList> addPriceItemsToPriceList(List<PriceItemDto> items) {
        List<PriceItemOnPriceList> priceItems = new ArrayList<>();
        items.forEach(item -> {
            PriceItemOnPriceList priceItem = new PriceItemOnPriceList();
            priceItem.setPrice(item.getPrice());
            priceItem.setPriceItemType(this.priceItemTypeRepository.findById(item.getPriceItemTypeId()).orElse(null));
            priceItem.setPriceList(this.priceListRepository.findById(item.getPriceListId()).orElse(null));
            priceItem.setPass(this.passRepository.findById(item.getPassId()).orElse(null));
            priceItem.setTicket(this.ticketRepository.findById(item.getTicketId()).orElse(null));

            this.priceItemOnPriceListRepository.save(priceItem);
            priceItems.add(priceItem);
        });
        return priceItems;
    }

    public void deletePriceItem(int id) throws DataNotFoundException{
        Optional<PriceItemOnPriceList> toDelete = priceItemOnPriceListRepository.findAll().stream().filter(item -> item.getId() == id).findFirst();
        priceItemOnPriceListRepository.delete(toDelete.orElseThrow(DataNotFoundException::new));
    }

    public void updatePriceItem(int id, PriceItemDto toUpdate) throws DataNotFoundException {
        System.out.println(String.format("price item id = %s", id));
        PriceItemOnPriceList entity = priceItemOnPriceListRepository.findAll().stream().filter(item -> item.getId() == id)
                .findFirst().orElse(null);
        entity.setPrice(Optional.ofNullable(toUpdate.getPrice()).orElse(entity.getPrice()));
        entity.setPriceItemType(Optional.ofNullable(toUpdate.getPriceItemTypeId())
                .map(i -> this.priceItemTypeRepository.findById(i)).orElse(null)
                .orElse(entity.getPriceItemType()));
        entity.setPriceList(Optional.ofNullable(toUpdate.getPriceListId())
                .map(i -> this.priceListRepository.findById(i)).orElse(null)
                .orElse(entity.getPriceList()));
        entity.setPass(Optional.ofNullable(toUpdate.getPassId())
                .map(i -> this.passRepository.findById(i)).orElse(null)
                .orElse(entity.getPass()));
        entity.setTicket(Optional.ofNullable(toUpdate.getTicketId())
                .map(i -> this.ticketRepository.findById(i)).orElse(null)
                .orElse(entity.getTicket()));

        priceItemOnPriceListRepository.save(entity);
    }
}
