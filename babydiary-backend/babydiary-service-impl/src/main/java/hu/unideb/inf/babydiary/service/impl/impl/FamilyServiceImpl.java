package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.FamilyRequest;
import hu.unideb.inf.babydiary.persistence.entity.FamilyEntity;
import hu.unideb.inf.babydiary.persistence.repository.FamilyRepository;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import hu.unideb.inf.babydiary.service.api.service.FamilyService;
import hu.unideb.inf.babydiary.service.impl.converter.family.FamilyEntityListToFamilyListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.family.FamilyEntityToFamilyConverter;
import hu.unideb.inf.babydiary.service.impl.converter.family.FamilyRequestToFamilyConverter;
import hu.unideb.inf.babydiary.service.impl.converter.family.FamilyToFamilyEntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository familyRepository;
    private final FamilyRequestToFamilyConverter fromRequest;
    private final FamilyEntityToFamilyConverter toDomain;
    private final FamilyToFamilyEntityConverter toEntity;
    private final FamilyEntityListToFamilyListConverter toDomainList;

    @Override
    public void saveFamily(FamilyRequest familyRequest) {
        Family family = fromRequest.convert(familyRequest);
        log.info(">> save: [family:{}]", family);
        assert family != null;
        FamilyEntity converted = toEntity.convert(family);
        log.info("<< save: [family:{}]", family);
        assert converted != null;
        familyRepository.save(converted);
    }

    @Override
    public Family findFamilyById(Long id) {
        FamilyEntity familyEntity = familyRepository.getOne(id);
        return toDomain.convert(familyEntity);
    }

    @Override
    public List<Family> findAllFamilies() {
        List<FamilyEntity> familyEntities = familyRepository.findAll();
        return toDomainList.convert(familyEntities);
    }
}
