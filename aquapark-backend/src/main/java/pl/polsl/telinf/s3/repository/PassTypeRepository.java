package pl.polsl.telinf.s3.repository;

import pl.polsl.telinf.s3.domain.model.pass.PassType;

import java.util.List;
import java.util.Optional;

public interface PassTypeRepository {
    List<PassType> findAll();
    Optional<PassType> findById(int id);
    PassType save(PassType entity);
}
