package pl.polsl.telinf.s3.service;

import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.model.pass.Pass;
import pl.polsl.telinf.s3.domain.model.pass.PassType;
import pl.polsl.telinf.s3.repository.PassRepository;
import pl.polsl.telinf.s3.repository.PassTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassService {
    private PassRepository passRepository;
    private PassTypeRepository passTypeRepository;

    public PassService(PassRepository passRepository, PassTypeRepository passTypeRepository) {
        this.passRepository = passRepository;
        this.passTypeRepository = passTypeRepository;
    }

    public List<Pass> findAllPasses() {
        return passRepository.findAll();
    }

    public Optional<Pass> findPassById(int id) {
        return passRepository.findById(id);
    }

    public List<PassType> findAllPassTypes() {
        return passTypeRepository.findAll();
    }

    public Optional<PassType> findPassTypeById(int id) {
        return passTypeRepository.findById(id);
    }
}
