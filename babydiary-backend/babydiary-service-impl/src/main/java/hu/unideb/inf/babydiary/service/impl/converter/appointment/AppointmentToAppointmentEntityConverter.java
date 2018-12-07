package hu.unideb.inf.babydiary.service.impl.converter.appointment;

import hu.unideb.inf.babydiary.persistence.entity.AppointmentEntity;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentToAppointmentEntityConverter implements Converter<Appointment,AppointmentEntity> {

    @Override
    public AppointmentEntity convert(Appointment appointment) {
        return AppointmentEntity.builder()
                .id(appointment.getId())
                .address(appointment.getAddress())
                .location(appointment.getLocation())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .description(appointment.getDescription())
                .prio(appointment.getPrio())
                .build();
    }
}
