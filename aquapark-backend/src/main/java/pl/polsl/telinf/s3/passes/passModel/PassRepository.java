package pl.polsl.telinf.s3.passes.passModel;

import java.util.List;
import java.util.Optional;

public interface PassRepository {
    List<Pass> findAll();
    Optional<Pass> findById(int id);
    Pass save(Pass entity);
}
