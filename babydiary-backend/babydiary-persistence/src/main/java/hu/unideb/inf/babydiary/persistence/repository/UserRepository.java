package hu.unideb.inf.babydiary.persistence.repository;

import hu.unideb.inf.babydiary.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
