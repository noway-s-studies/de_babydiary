package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.backend.security.SecurityContextHolderUtil;
import hu.unideb.inf.babydiary.commons.pojo.request.RegistrationRequest;
import hu.unideb.inf.babydiary.commons.pojo.response.UserResponse;
import hu.unideb.inf.babydiary.commons.pojo.validator.ViolationResponse;
import hu.unideb.inf.babydiary.service.api.domain.User;
import hu.unideb.inf.babydiary.service.api.exception.UserAlreadyExistsExeption;
import hu.unideb.inf.babydiary.service.api.exception.UserNotFoundExeption;
import hu.unideb.inf.babydiary.service.api.service.RegistrationService;
import hu.unideb.inf.babydiary.service.api.service.UserService;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserToUserResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static hu.unideb.inf.babydiary.commons.pojo.path.UserPath.*;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final RegistrationService registrationService;
    private final UserService userService;
    private final UserToUserResponseConverter toResponse;

    @RequestMapping(value = REGISTRATION_URL, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
        return ResponseEntity.ok(registrationRequest);
    }

    @GetMapping(LOGIN_URL)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponse> authorizedUser() {
        User user = SecurityContextHolderUtil.getUser();
        return ResponseEntity.ok(Objects.requireNonNull(toResponse.convert(user)));
    }

    @GetMapping(USER_ID_URL)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(Objects.requireNonNull(toResponse.convert(user)));
    }

    @GetMapping(USERS_URL)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Collection<UserResponse>> getAllUser() {
        List<UserResponse> userList = userService.findAll();
        return ResponseEntity.accepted().body(userList);
    }

    @ExceptionHandler(UserAlreadyExistsExeption.class)
    public ResponseEntity<ViolationResponse> handleUserAlreadyExistsException(final UserAlreadyExistsExeption exeption) {
        final ViolationResponse violationResponse = new ViolationResponse();
        violationResponse.addError(exeption.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(violationResponse);
    }

    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<ViolationResponse> handleUserNotFoundException(final UserNotFoundExeption exeption) {
        final ViolationResponse violationResponse = new ViolationResponse();
        violationResponse.addError(exeption.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(violationResponse);
    }
}
