package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.ChildRequest;
import hu.unideb.inf.babydiary.service.api.domain.Child;

import java.util.List;

public interface ChildService {

    void saveChild(ChildRequest childRequest);

    Child findChildById(Long id);

    List<Child> findAllChildren();
}
