package hu.unideb.inf.babydiary.service.impl.converter.family;

import hu.unideb.inf.babydiary.persistence.entity.FamilyEntity;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FamilyEntityListToFamilyListConverter implements Converter<List<FamilyEntity>, List<Family>> {

    private final FamilyEntityToFamilyConverter toFamilyConverter;

    @Override
    public List<Family> convert(List<FamilyEntity> familyEntities) {
        return familyEntities.stream().map(toFamilyConverter::convert).collect(Collectors.toList());
    }
}
