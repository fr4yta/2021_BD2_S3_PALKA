package pl.polsl.telinf.s3.service;

import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.dto.PurchaseById;
import pl.polsl.telinf.s3.domain.dto.PurchaseByUser;
import pl.polsl.telinf.s3.domain.dto.PurchaseDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.domain.dto.exception.DataNotFoundException;
import pl.polsl.telinf.s3.domain.model.purchase.Purchase;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAPriceItemOnPriceListRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAPurchaseRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;
import pl.polsl.telinf.s3.security.JwtTokenUtil;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {
    private JPAPurchaseRepository purchaseRepository;
    private JPAPriceItemOnPriceListRepository priceItemRepository;
    private JPAUserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;
    private PriceListService priceListService;

    public PurchaseService(JPAPurchaseRepository purchaseRepository, JPAPriceItemOnPriceListRepository priceItemRepository, JPAUserRepository userRepository, JwtTokenUtil jwtTokenUtil, PriceListService priceListService) {
        this.purchaseRepository = purchaseRepository;
        this.priceItemRepository = priceItemRepository;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.priceListService = priceListService;
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public PurchaseById findById(int id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(DataNotFoundException::new);
        PurchaseById response = new PurchaseById();
        response.setId(purchase.getId());
        response.setUser(purchase.getUser());
        response.setEntryDate(purchase.getEntryDate());
        response.setPurchaseDate(purchase.getPurchaseDate());
        response.setPriceItem(priceListService.findPriceItemByPurchaseId(id));

        return response;
    }

    public List<PurchaseByUser> findByUser(String token) throws CustomException {
        User user = userRepository.findById(Integer.valueOf(jwtTokenUtil.getUserId(UserService.modifyUserToken(token))))
                .orElseThrow(DataNotFoundException::new);
        List<Purchase> purchases = purchaseRepository.findAllByUserId(user.getId());
        List<PurchaseByUser> response = new ArrayList<>();
        purchases.forEach(purchase -> {
            PurchaseByUser p = new PurchaseByUser();
            p.setId(purchase.getId());
            p.setPurchaseDate(purchase.getPurchaseDate());
            p.setEntryDate(purchase.getEntryDate());
            p.setPriceItem(priceListService.findPriceItemByPurchaseId(purchase.getId()));
            response.add(p);
        });

        return response;
    }

    public Purchase purchase(String token, PurchaseDto purchaseDto) throws CustomException {
        User user = userRepository.findById(Integer.valueOf(jwtTokenUtil.getUserId(UserService.modifyUserToken(token))))
                .orElseThrow(DataNotFoundException::new);
        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setItem(priceItemRepository.findAll().stream().filter(item -> item.getId() == purchaseDto.getPriceItemId())
                .findFirst().orElseThrow(DataNotFoundException::new));
        purchase.setEntryDate(purchaseDto.getEntryDate());
        purchase.setPurchaseDate(Timestamp.from(Instant.now()));

        purchaseRepository.save(purchase);
        return purchase;

    }
}
