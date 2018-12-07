package hu.unideb.inf.babydiary.service.impl.converter.funfact;

import hu.unideb.inf.babydiary.persistence.entity.FunfactEntity;
import hu.unideb.inf.babydiary.service.api.domain.Funfact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FunfactEntityToFunfactConverter implements Converter<FunfactEntity, Funfact> {
    @Override
    public Funfact convert(FunfactEntity funfactEntity) {
        return Funfact.builder()
                .id(funfactEntity.getId())
                .text(funfactEntity.getText())
                .week(funfactEntity.getWeek())
                .food(funfactEntity.getFood())
                .music(funfactEntity.getMusic())
                .skills(funfactEntity.getSkills())
                .build();
    }
}
