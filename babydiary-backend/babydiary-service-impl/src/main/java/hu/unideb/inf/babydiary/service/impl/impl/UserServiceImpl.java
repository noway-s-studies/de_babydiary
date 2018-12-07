package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.response.UserResponse;
import hu.unideb.inf.babydiary.persistence.entity.UserEntity;
import hu.unideb.inf.babydiary.persistence.repository.UserRepository;
import hu.unideb.inf.babydiary.service.api.domain.User;
import hu.unideb.inf.babydiary.service.api.exception.UserAlreadyExistsExeption;
import hu.unideb.inf.babydiary.service.api.exception.UserNotFoundExeption;
import hu.unideb.inf.babydiary.service.api.service.UserService;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserEntityListToUserListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserEntityToUserConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserToUserEntityConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserToUserResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_ALREADY_EXISTS = "User already exists: %s";
    private static final String USER_ID_NOT_FOUND = "User not found by id: %d";
    private static final String USER_NAME_NOT_FOUND = "User not found by name: %s";

    private final UserToUserEntityConverter toEntity;
    private final UserEntityToUserConverter toUser;
    private final UserEntityListToUserListConverter toUserList;
    private final UserRepository userRepository;
    private final UserToUserResponseConverter toResponse;

    @Override
    public void addUser(User user){
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsExeption(String.format(USER_ALREADY_EXISTS, user.getUsername()));
        }
        toUser.convert(userRepository.save(Objects.requireNonNull(toEntity.convert(user))));
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(
                        ()-> new UserNotFoundExeption(String.format(USER_ID_NOT_FOUND, id))
                );
        return toUser.convert(userEntity);
    }

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(
                ()-> new UserNotFoundExeption(String.format(USER_NAME_NOT_FOUND, username))
        );
        return toUser.convert(userEntity);
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return toUserList.convert(userEntities).stream().map(toResponse::convert).collect(Collectors.toList());
    }
}
