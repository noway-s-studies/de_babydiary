package hu.unideb.inf.babydiary.service.impl.converter.child;

import hu.unideb.inf.babydiary.persistence.entity.ChildEntity;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChildEntityListToChildListConverter implements Converter<List<ChildEntity>, List<Child>> {

    private final ChildEntityToChildConverter toChildConverter;

    @Override
    public List<Child> convert(List<ChildEntity> childEntities) {
        return childEntities.stream().map(toChildConverter::convert).collect(Collectors.toList());
    }
}
