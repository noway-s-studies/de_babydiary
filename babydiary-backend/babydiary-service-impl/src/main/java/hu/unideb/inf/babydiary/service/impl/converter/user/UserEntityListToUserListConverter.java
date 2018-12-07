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
public class UserEntityListToUserListConverter implements Converter<List<UserEntity>, List<User>> {

    private final UserEntityToUserConverter toDomain;

    @Override
    public List<User> convert(List<UserEntity> userEntities) {
        return userEntities.stream().map(toDomain::convert).collect(Collectors.toList());
    }
}
