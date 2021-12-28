package pl.polsl.telinf.s3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemType;
import pl.polsl.telinf.s3.domain.model.priceList.PriceList;
import pl.polsl.telinf.s3.service.PriceListService;

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
}
