package hu.unideb.inf.babydiary.persistence.repository;

import hu.unideb.inf.babydiary.persistence.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository  extends JpaRepository<FamilyEntity, Long> {

}
