package pl.polsl.telinf.s3.repository;

import pl.polsl.telinf.s3.domain.model.pass.Pass;

import java.util.List;
import java.util.Optional;

public interface PassRepository {
    List<Pass> findAll();
    Optional<Pass> findById(int id);
    Pass save(Pass entity);
}
