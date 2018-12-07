package hu.unideb.inf.babydiary.service.api.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Album implements Serializable {

    private Long id;
    private String name;
    private String link;
}
