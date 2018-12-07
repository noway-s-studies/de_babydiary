package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.commons.pojo.request.FamilyRequest;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import hu.unideb.inf.babydiary.service.api.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.path.FamilyPath.*;

@RestController
@RequiredArgsConstructor
public class FamilyRestController {

    private final FamilyService familyService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = FAMILY_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody FamilyRequest familyRequest) {
        familyService.saveFamily(familyRequest);
        return ResponseEntity.ok(familyRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = FAMILY_GETONE)
    public ResponseEntity<?> getFamilyById(@PathVariable Long id) {
        Family family = familyService.findFamilyById(id);
        return ResponseEntity.accepted().body(family);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = FAMILY_GETALL)
    public ResponseEntity<?> getAll() {
        List<Family> familyList = familyService.findAllFamilies();
        return  ResponseEntity.accepted().body(familyList);
    }
}
