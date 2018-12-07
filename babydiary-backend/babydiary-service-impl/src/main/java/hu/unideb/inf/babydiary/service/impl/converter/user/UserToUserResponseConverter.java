package hu.unideb.inf.babydiary.service.impl.converter.user;

import hu.unideb.inf.babydiary.commons.pojo.response.UserResponse;
import hu.unideb.inf.babydiary.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseConverter implements Converter<User, UserResponse> {

    @Override
    public UserResponse convert(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .sex(user.getSex())
                .userRole(user.getUserRole().toString())
                .build();
    }
}
