package hu.unideb.inf.babydiary.service.impl.converter.funfact;

import hu.unideb.inf.babydiary.persistence.entity.FunfactEntity;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FunfactToFunfactEntityConverter implements Converter<Funfact, FunfactEntity> {

    @Override
    public FunfactEntity convert(Funfact funfact) {
        return FunfactEntity.builder()
                .id(funfact.getId())
                .text(funfact.getText())
                .week(funfact.getWeek())
                .skills(funfact.getSkills())
                .food(funfact.getFood())
                .music(funfact.getMusic())
                .build();
    }
}
