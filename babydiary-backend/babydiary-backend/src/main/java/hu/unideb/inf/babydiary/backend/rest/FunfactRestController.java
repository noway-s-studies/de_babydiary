package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.commons.pojo.request.FunfactRequest;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import hu.unideb.inf.babydiary.service.api.service.FunfactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.path.FunfactPath.FUNFACT_ADD;
import static hu.unideb.inf.babydiary.commons.pojo.path.FunfactPath.FUNFACT_GETALL;
import static hu.unideb.inf.babydiary.commons.pojo.path.FunfactPath.FUNFACT_GETONE;

@RestController
@RequiredArgsConstructor
public class FunfactRestController {

    private final FunfactService funfactService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = FUNFACT_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody FunfactRequest funfactRequest) {
        funfactService.saveFunfact(funfactRequest);
        return ResponseEntity.ok(funfactRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = FUNFACT_GETONE)
    public ResponseEntity<?> getFunfactBy(@PathVariable Long id) {
        Funfact funfact = funfactService.findFunfactById(id);
        return ResponseEntity.accepted().body(funfact);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = FUNFACT_GETALL)
    public ResponseEntity<?> getAll() {
        List<Funfact> funfacts = funfactService.findAllFunfact();
        return ResponseEntity.accepted().body(funfacts);
    }

}
