package pl.polsl.telinf.s3.passes.passTypeModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAPassTypeRepository extends PassTypeRepository, JpaRepository<PassType, Integer> {
}
