package pl.polsl.telinf.s3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.telinf.s3.domain.dto.PriceItemDto;
import pl.polsl.telinf.s3.domain.dto.PriceListDto;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemType;
import pl.polsl.telinf.s3.domain.model.priceList.PriceList;
import pl.polsl.telinf.s3.service.PriceListService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/priceList")
public class PriceListController {
    private PriceListService priceListService;

    public PriceListController(PriceListService priceListService) {
        this.priceListService = priceListService;
    }

    @GetMapping(path = "/actualPriceItems")
    ResponseEntity<List<PriceItemOnPriceList>> findActualPriceItems(){
        return ResponseEntity.ok(priceListService.findActualPriceItems());
    }

    @GetMapping(path = "/actualPriceList")
    ResponseEntity<PriceList> findActualPriceList(){
        return ResponseEntity.ok(priceListService.findActivePriceList());
    }

    @GetMapping(path = "/priceLists")
    ResponseEntity<List<PriceList>> findAllPriceLists(){
        return ResponseEntity.ok(priceListService.findAllPriceLists());
    }

    @GetMapping(path = "/priceItemTypes")
    ResponseEntity<List<PriceItemType>> findAllPriceItemTypes(){
        return ResponseEntity.ok(priceListService.findAllPriceItemTypes());
    }

    @GetMapping(path = "/priceItems")
    ResponseEntity<List<PriceItemOnPriceList>> findAllPriceItems () {
        return ResponseEntity.ok(priceListService.findAllPriceItems());
    }

    //POSTS
    @PostMapping(path = "/addList")
    ResponseEntity<PriceList> addNewPriceList(@RequestBody @Valid PriceListDto priceListDto) {
        PriceList created = priceListService.addNewPriceList(priceListDto.getName(), priceListDto.getValidFrom(),
                priceListDto.getValidTo());
        URI location = URI.create(String.format("/%s", created.getId()));

        priceListService.addPriceItemsToPriceList(priceListDto.getItems());
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping(path ="/addItems")
    ResponseEntity<List<PriceItemOnPriceList>> addNewPriceItems(@RequestBody @Valid List<PriceItemDto> items) {
        List<PriceItemOnPriceList> priceItems = priceListService.addPriceItemsToPriceList(items);
        URI location = URI.create(String.format("/%s", priceItems.get(0).getId()));
        return ResponseEntity.created(location).body(priceItems);
    }
}
