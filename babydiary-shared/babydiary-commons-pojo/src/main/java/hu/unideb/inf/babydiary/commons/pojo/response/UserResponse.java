package hu.unideb.inf.babydiary.commons.pojo.response;

import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String userRole;
    private String email;
    private String firstName;
    private String lastName;
    private Sex sex;
}
