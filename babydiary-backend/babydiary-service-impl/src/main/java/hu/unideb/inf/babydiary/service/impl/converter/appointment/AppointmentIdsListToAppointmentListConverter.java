package hu.unideb.inf.babydiary.service.impl.converter.appointment;

import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import hu.unideb.inf.babydiary.service.api.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppointmentIdsListToAppointmentListConverter implements Converter<List<Long>, List<Appointment>> {

    private final AppointmentService appointmentService;

    @Override
    public List<Appointment> convert(List<Long> longs) {
        return longs.stream().map(appointmentService::findAppointmentById).collect(Collectors.toList());
    }
}
