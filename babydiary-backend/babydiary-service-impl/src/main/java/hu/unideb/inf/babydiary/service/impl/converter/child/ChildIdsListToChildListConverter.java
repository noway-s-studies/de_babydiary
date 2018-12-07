package hu.unideb.inf.babydiary.service.impl.converter.child;

import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.api.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChildIdsListToChildListConverter implements Converter<List<Long>, List<Child>> {

    private final ChildService childService;

    @Override
    public List<Child> convert(List<Long> longs) {
        return longs.stream().map(childService::findChildById).collect(Collectors.toList());
    }
}
