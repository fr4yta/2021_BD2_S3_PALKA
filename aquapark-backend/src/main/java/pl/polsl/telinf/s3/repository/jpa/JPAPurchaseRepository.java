package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.purchase.Purchase;

import java.util.List;

@Repository
public interface JPAPurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("select p from Purchase p where p.user.id = ?1")
    List<Purchase> findAllByUserId(int userId);
}
