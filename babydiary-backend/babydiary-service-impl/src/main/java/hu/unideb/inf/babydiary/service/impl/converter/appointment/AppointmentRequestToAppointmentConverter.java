package hu.unideb.inf.babydiary.service.impl.converter.appointment;

import hu.unideb.inf.babydiary.commons.pojo.request.AppointmentRequest;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AppointmentRequestToAppointmentConverter implements Converter<AppointmentRequest,Appointment> {

    @Override
    public Appointment convert(AppointmentRequest appointmentRequest) {
        return Appointment.builder()
                .address(appointmentRequest.getAddress())
                .location(appointmentRequest.getLocation())
                .date(appointmentRequest.getDate())
                .time(appointmentRequest.getTime())
                .description(appointmentRequest.getDescription())
                .prio(appointmentRequest.getPrio())
                .build();
    }
}
