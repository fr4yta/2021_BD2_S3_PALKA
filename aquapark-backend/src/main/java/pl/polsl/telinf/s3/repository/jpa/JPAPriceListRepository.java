package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.priceList.PriceList;

@Repository
public interface JPAPriceListRepository extends JpaRepository<PriceList,Integer> {
}
