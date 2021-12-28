package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.telinf.s3.repository.PassTypeRepository;
import pl.polsl.telinf.s3.domain.model.pass.PassType;

public interface JPAPassTypeRepository extends PassTypeRepository, JpaRepository<PassType, Integer> {
}
