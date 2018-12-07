package hu.unideb.inf.babydiary.service.impl.converter.funfact;

import hu.unideb.inf.babydiary.commons.pojo.request.FunfactRequest;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FunfactRequestToFunfactConverter implements Converter<FunfactRequest, Funfact> {

    @Override
    public Funfact convert(FunfactRequest funfactRequest) {
        return Funfact.builder()
                .text(funfactRequest.getText())
                .week(funfactRequest.getWeek())
                .food(funfactRequest.getFood())
                .music(funfactRequest.getMusic())
                .skills(funfactRequest.getSkills())
                .build();
    }
}
