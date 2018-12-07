package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.FunfactRequest;
import hu.unideb.inf.babydiary.persistence.entity.FunfactEntity;
import hu.unideb.inf.babydiary.persistence.repository.FunfactRepository;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import hu.unideb.inf.babydiary.service.api.service.FunfactService;
import hu.unideb.inf.babydiary.service.impl.converter.funfact.FunfactEntityListToFunfactListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.funfact.FunfactEntityToFunfactConverter;
import hu.unideb.inf.babydiary.service.impl.converter.funfact.FunfactRequestToFunfactConverter;
import hu.unideb.inf.babydiary.service.impl.converter.funfact.FunfactToFunfactEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FunfactServiceImpl implements FunfactService {

    private final FunfactRepository funfactRepository;
    private final FunfactRequestToFunfactConverter fromRequest;
    private final FunfactEntityToFunfactConverter toDomain;
    private final FunfactToFunfactEntityConverter toEntity;
    private final FunfactEntityListToFunfactListConverter toDomainList;

    @Override
    public void saveFunfact(FunfactRequest funfactRequest){
        Funfact funfact = fromRequest.convert(funfactRequest);
        assert funfact != null;
        FunfactEntity funfactEntity = toEntity.convert(funfact);
        assert funfactEntity != null;
        funfactRepository.save(funfactEntity);
        }

    @Override
    public Funfact findFunfactById(Long id) {
        FunfactEntity funfactEntity = funfactRepository.getOne(id);
        return toDomain.convert(funfactEntity);
    }

    @Override
    public List<Funfact> findAllFunfact() {
        List<FunfactEntity> funfactEntities = funfactRepository.findAll();
        return toDomainList.convert(funfactEntities);
    }
}
