package hu.unideb.inf.babydiary.service.api.validator.rule;

import hu.unideb.inf.babydiary.commons.pojo.validator.Violation;

import java.util.List;

public interface Rule<T> {

    List<Violation> validate(T request);
}
