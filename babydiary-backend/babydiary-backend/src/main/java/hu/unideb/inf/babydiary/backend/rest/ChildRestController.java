package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.commons.pojo.request.ChildRequest;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.api.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.path.ChildPath.*;

@RestController
@RequiredArgsConstructor
public class ChildRestController {

    private final ChildService childService;

    @RequestMapping(value = CHILD_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody ChildRequest childRequest) {
        childService.saveChild(childRequest);
        return ResponseEntity.ok(childRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = CHILD_GETONE)
    public ResponseEntity<?> getChildById(@PathVariable Long id) {
        Child child = childService.findChildById(id);
        return ResponseEntity.accepted().body(child);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = CHILD_GETALL)
    public ResponseEntity<?> getAllChildren() {
        List<Child> childList = childService.findAllChildren();
        return  ResponseEntity.accepted().body(childList);
    }
}
