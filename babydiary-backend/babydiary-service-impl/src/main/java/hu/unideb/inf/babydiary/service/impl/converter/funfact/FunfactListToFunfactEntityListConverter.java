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
public class FunfactListToFunfactEntityListConverter implements Converter<List<Funfact>, List<FunfactEntity>> {

    private final FunfactToFunfactEntityConverter toFunfactEntityConverter;

    @Override
    public List<FunfactEntity> convert(List<Funfact> funfacts) {
        return funfacts.stream().map(toFunfactEntityConverter::convert).collect(Collectors.toList());
    }
}
