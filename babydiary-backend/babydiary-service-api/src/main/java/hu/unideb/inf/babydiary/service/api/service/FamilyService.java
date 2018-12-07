package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.FamilyRequest;
import hu.unideb.inf.babydiary.service.api.domain.Family;

import java.util.List;

public interface FamilyService {

    void saveFamily(FamilyRequest familyRequest);

    Family findFamilyById(Long id);

    List<Family> findAllFamilies();
}
