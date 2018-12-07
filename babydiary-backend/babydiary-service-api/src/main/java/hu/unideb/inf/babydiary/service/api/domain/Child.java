package hu.unideb.inf.babydiary.service.api.domain;

import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Child implements Serializable {

    private Long id;

    private LocalDate birthday;

    private String firstName;

    private String lastName;

    private Sex sex;

    private LocalDate conception;

    private int height;

    private int weight;

    private List<Album> albums;
}
