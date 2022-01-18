package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.purchase.Purchase;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAPurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("SELECT p FROM Purchase p WHERE p.id = ?1")
    Optional<Purchase> findById(int id);

    @Query(value = "SELECT * FROM purchases p JOIN price_items_on_price_lists i ON p.price_item_id= i.id WHERE p.user_id = ?1",
    nativeQuery = true)
    List<Purchase> findAllByUserId(int userId);
}
