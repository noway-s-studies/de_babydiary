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
public class ChildListToChildEntityListConverter implements Converter<List<Child>, List<ChildEntity>> {

    private final ChildToChildEntityConverter toChildEntityConverter;

    @Override
    public List<ChildEntity> convert(List<Child> children) {
        return children.stream().map(toChildEntityConverter::convert).collect(Collectors.toList());
    }
}
