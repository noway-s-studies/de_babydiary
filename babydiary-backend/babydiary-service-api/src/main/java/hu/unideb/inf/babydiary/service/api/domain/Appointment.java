package hu.unideb.inf.babydiary.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements Serializable {

    private Long id;

    private String address;

    private String location;

    private String description;

    private int prio;

    private LocalDate date;

    private LocalDateTime time;

}
