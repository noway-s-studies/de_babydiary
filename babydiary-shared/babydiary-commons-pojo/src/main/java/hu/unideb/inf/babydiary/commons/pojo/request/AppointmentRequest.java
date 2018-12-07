package hu.unideb.inf.babydiary.commons.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {

    private String address;

    private String location;

    private String description;

    private int prio;

    private LocalDate date;

    private LocalDateTime time;

}
