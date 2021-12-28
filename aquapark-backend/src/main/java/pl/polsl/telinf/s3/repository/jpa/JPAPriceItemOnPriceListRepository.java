package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemOnPriceList;

import java.util.List;

@Repository
public interface JPAPriceItemOnPriceListRepository extends JpaRepository<PriceItemOnPriceList, Integer> {

    List<PriceItemOnPriceList> findAllByPriceListName(String name);
}
