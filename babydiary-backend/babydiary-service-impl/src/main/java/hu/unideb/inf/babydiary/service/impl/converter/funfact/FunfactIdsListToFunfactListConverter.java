package hu.unideb.inf.babydiary.service.impl.converter.funfact;

import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import hu.unideb.inf.babydiary.service.api.service.FunfactService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FunfactIdsListToFunfactListConverter implements Converter<List<Long>, List<Funfact>> {

    private final FunfactService funfactService;

    @Override
    public List<Funfact> convert(List<Long> longs){
        return longs.stream().map(funfactService::findFunfactById).collect(Collectors.toList());
    }
}
