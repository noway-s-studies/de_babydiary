package hu.unideb.inf.babydiary.service.impl.converter.user;

import hu.unideb.inf.babydiary.persistence.entity.UserEntity;
import hu.unideb.inf.babydiary.service.api.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserListToUserEntityConverter implements Converter<List<User>, List<UserEntity>> {

    private final UserToUserEntityConverter toUserEntityConverter;

    @Override
    public List<UserEntity> convert(List<User> users) {
        return users.stream().map(toUserEntityConverter::convert).collect(Collectors.toList());
    }
}
