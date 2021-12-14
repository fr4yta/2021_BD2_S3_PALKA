package pl.polsl.telinf.s3.passes.passModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPassRepository extends PassRepository, JpaRepository<Pass, Integer> {
}
