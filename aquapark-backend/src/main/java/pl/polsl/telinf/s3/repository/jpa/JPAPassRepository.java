package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.repository.PassRepository;
import pl.polsl.telinf.s3.domain.model.pass.Pass;

@Repository
public interface JPAPassRepository extends PassRepository, JpaRepository<Pass, Integer> {
}
