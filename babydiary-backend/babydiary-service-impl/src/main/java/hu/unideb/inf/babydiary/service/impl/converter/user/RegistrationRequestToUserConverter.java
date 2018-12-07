package hu.unideb.inf.babydiary.service.impl.converter.user;

import hu.unideb.inf.babydiary.commons.pojo.request.RegistrationRequest;
import hu.unideb.inf.babydiary.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestToUserConverter implements Converter<RegistrationRequest, User> {

    private static final BCryptPasswordEncoder PW_ENCODE = new BCryptPasswordEncoder();

    @Override
    public User convert(RegistrationRequest registrationRequest) {
        return User.builder()
                .username(registrationRequest.getUsername())
                .email(registrationRequest.getEmail())
                .password(PW_ENCODE.encode(registrationRequest.password))
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .sex(registrationRequest.getSex())
                .userRole(registrationRequest.getUserRole())
                .build();
    }
}
