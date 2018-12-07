package hu.unideb.inf.babydiary.service.impl.converter.funfact;

import hu.unideb.inf.babydiary.persistence.entity.FunfactEntity;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FunfactEntityListToFunfactListConverter implements Converter<List<FunfactEntity>,List<Funfact>> {

    private final FunfactEntityToFunfactConverter toFunfactConverter;

    @Override
    public List<Funfact> convert(List<FunfactEntity> funfactEntities) {
        return funfactEntities.stream().map(toFunfactConverter::convert).collect(Collectors.toList());
    }
}
