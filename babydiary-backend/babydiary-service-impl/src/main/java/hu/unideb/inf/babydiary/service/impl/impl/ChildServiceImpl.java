package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.ChildRequest;
import hu.unideb.inf.babydiary.persistence.entity.ChildEntity;
import hu.unideb.inf.babydiary.persistence.repository.ChildRepository;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.api.service.ChildService;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildEntityListToChildListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildEntityToChildConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildRequestToChildConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildToChildEntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChildServiceImpl implements ChildService {

    private final ChildToChildEntityConverter toEntity;
    private final ChildEntityToChildConverter toChildConverter;
    private final ChildRequestToChildConverter fromRequest;
    private final ChildEntityListToChildListConverter toDomainList;
    private final ChildRepository childRepository;

    @Override
    public void saveChild(ChildRequest childRequest) {
        Child child = fromRequest.convert(childRequest);
        log.info(">> save: [child:{}]", child);
        assert child != null;
        ChildEntity converted = toEntity.convert(child);
        log.info("<< save: [child:{}]", child);
        assert converted != null;
        childRepository.save(converted);
    }

    @Override
    public Child findChildById(Long id) {
        ChildEntity childEntity = childRepository.getOne(id);
        return toChildConverter.convert(childEntity);
    }

    @Override
    public List<Child> findAllChildren() {
        List<ChildEntity> findAllChildren = childRepository.findAll();
        return toDomainList.convert(findAllChildren);
    }
}
