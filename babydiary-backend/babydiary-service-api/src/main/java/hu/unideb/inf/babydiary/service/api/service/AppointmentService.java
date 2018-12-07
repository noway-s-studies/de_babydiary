package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.AppointmentRequest;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;

import java.util.List;

public interface AppointmentService {

    void saveAppointment(AppointmentRequest appointmentRequest);

    Appointment findAppointmentById(Long id);

    List<Appointment> findAllAppointment();

}
