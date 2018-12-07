package hu.unideb.inf.babydiary.commons.pojo.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViolationResponse {

    public List<Violation> errors;

    public void addError(final String message) {
        this.errors.add(new Violation(message));
    }
}
