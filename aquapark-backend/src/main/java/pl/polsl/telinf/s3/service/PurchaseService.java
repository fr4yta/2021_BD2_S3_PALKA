package pl.polsl.telinf.s3.service;

import org.springframework.stereotype.Service;
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
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private JPAPurchaseRepository purchaseRepository;
    private JPAPriceItemOnPriceListRepository priceItemRepository;
    private JPAUserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    public PurchaseService(JPAPurchaseRepository purchaseRepository, JPAPriceItemOnPriceListRepository priceItemRepository, JPAUserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.purchaseRepository = purchaseRepository;
        this.priceItemRepository = priceItemRepository;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> findById(int id) {
        Optional<Purchase> purchase = purchaseRepository.findAll().stream().findAny();
        return purchase;
    }

    public List<Purchase> findByUser(String token) throws CustomException {
        User user = userRepository.findById(Integer.valueOf(jwtTokenUtil.getUserId(UserService.modifyUserToken(token))))
                .orElseThrow(DataNotFoundException::new);

        return purchaseRepository.findAllByUserId(user.getId());
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
