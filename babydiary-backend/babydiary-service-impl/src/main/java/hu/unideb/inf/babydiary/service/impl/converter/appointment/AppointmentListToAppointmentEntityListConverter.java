package hu.unideb.inf.babydiary.service.impl.converter.appointment;

import hu.unideb.inf.babydiary.persistence.entity.AppointmentEntity;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppointmentListToAppointmentEntityListConverter implements Converter<List<Appointment>, List<AppointmentEntity>> {

    private final AppointmentToAppointmentEntityConverter toAppointmentEntityConverter;

    @Override
    public List<AppointmentEntity> convert(List<Appointment> appointments) {
        return appointments.stream().map(toAppointmentEntityConverter::convert).collect(Collectors.toList());
    }
}
