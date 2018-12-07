package hu.unideb.inf.babydiary.service.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import hu.unideb.inf.babydiary.commons.pojo.enumeration.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Sex sex;

    private UserRole userRole;

    @JsonIgnore
    private String passwordConfirm;
}
