package hu.unideb.inf.babydiary.commons.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import hu.unideb.inf.babydiary.commons.pojo.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest implements Serializable {

    public String username;

    public String email;

    public String password;

    @JsonIgnore
    public String passwordConfirm;

    public String firstName;

    public String lastName;

    public Sex sex;

    public UserRole userRole;
}
