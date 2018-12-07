package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.response.UserResponse;
import hu.unideb.inf.babydiary.service.api.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findById(Long id);

    User findByUsername(String username);

    List<UserResponse> findAll();
}
