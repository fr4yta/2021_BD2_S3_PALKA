package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.priceList.PriceItemType;

@Repository
public interface JPAPriceItemTypeRepository extends JpaRepository<PriceItemType,Integer> {
}
