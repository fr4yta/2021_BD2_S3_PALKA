package pl.polsl.telinf.s3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.telinf.s3.domain.model.pass.Pass;
import pl.polsl.telinf.s3.domain.model.pass.PassType;
import pl.polsl.telinf.s3.service.PassService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PassController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private PassService passService;

    public PassController(PassService passService) {
        this.passService = passService;
    }

    //PASSES:
    @GetMapping(path = "/passes")
    ResponseEntity<List<Pass>> findAllPasses() {
        logger.info("Exposing all passes");
        return ResponseEntity.ok(passService.findAllPasses());
    }

    @GetMapping(path = "/passes/{id}")
    ResponseEntity<Pass> findPassById(@PathVariable(name = "id") int id){
        return ResponseEntity.of(passService.findPassById(id));
    }

    //PASS_TYPES:

    @GetMapping(path = "/passTypes")
    ResponseEntity<List<PassType>> findAllPassTypes() {
        logger.info("Exposing all products");
        return ResponseEntity.ok(passService.findAllPassTypes());
    }

    @GetMapping(path = "/passTypes/{id}")
    ResponseEntity<PassType> findPassTypeById(@PathVariable(name = "id") int id){
        return ResponseEntity.of(passService.findPassTypeById(id));
    }
}
