package hu.unideb.inf.babydiary.service.impl.converter.user;

import hu.unideb.inf.babydiary.service.api.domain.User;
import hu.unideb.inf.babydiary.service.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserIdListToUserListConverter implements Converter<List<Long>, List<User>> {

    private final UserService userService;

    @Override
    public List<User> convert(List<Long> longs) {
        return longs.stream().map(userService::findById).collect(Collectors.toList());
    }
}
