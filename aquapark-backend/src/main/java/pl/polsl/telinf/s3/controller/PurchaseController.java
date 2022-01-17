package pl.polsl.telinf.s3.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.telinf.s3.domain.dto.PurchaseDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.domain.model.purchase.Purchase;
import pl.polsl.telinf.s3.service.PurchaseService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/purchase")
public class PurchaseController {
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> findAllPurchases() {
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Purchase> findPurchaseById(@PathVariable(name = "id") int id) {
        System.out.println("here");
        return ResponseEntity.of(purchaseService.findById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Purchase>> findPurchasesByUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token)
            throws CustomException {
        return ResponseEntity.ok(purchaseService.findByUser(token));
    }

    @PostMapping
    public ResponseEntity<Purchase> purchaseItem(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token,
                                                 @RequestBody PurchaseDto purchaseDto) throws CustomException {
        Purchase purchase = purchaseService.purchase(token, purchaseDto);
        URI location = URI.create(String.format("/api/purchase/%s", purchase.getId()));
        return ResponseEntity.created(location).body(purchase);
    }
}
