package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.FunfactRequest;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;

import java.util.List;

public interface FunfactService {

    void saveFunfact(FunfactRequest funfactRequest);

    Funfact findFunfactById(Long id);

    List<Funfact> findAllFunfact();
}
