package hu.unideb.inf.babydiary.service.api.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Funfact implements Serializable {

    private Long id;

    private String food;

    private String music;

    private String skills;

    private String text;

    private int week;
}
