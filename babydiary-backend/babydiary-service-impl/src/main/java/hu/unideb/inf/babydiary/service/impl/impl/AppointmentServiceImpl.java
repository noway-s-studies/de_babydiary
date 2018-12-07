package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.AppointmentRequest;
import hu.unideb.inf.babydiary.persistence.entity.AppointmentEntity;
import hu.unideb.inf.babydiary.persistence.repository.AppointmentRepository;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import hu.unideb.inf.babydiary.service.api.service.AppointmentService;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentEntityListToAppointmentListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentEntityToAppointmentConverter;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentRequestToAppointmentConverter;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentToAppointmentEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentRequestToAppointmentConverter fromRequest;
    private final AppointmentEntityToAppointmentConverter toDomain;
    private final AppointmentToAppointmentEntityConverter toEntity;
    private final AppointmentEntityListToAppointmentListConverter toDomainList;

    @Override
    public void saveAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = fromRequest.convert(appointmentRequest);
        assert appointment != null;
        AppointmentEntity appointmentEntity = toEntity.convert(appointment);
        assert appointmentEntity != null;
        appointmentRepository.save(appointmentEntity);
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        AppointmentEntity appointmentEntity = appointmentRepository.getOne(id);
        return toDomain.convert(appointmentEntity);
    }

    @Override
    public List<Appointment> findAllAppointment() {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAll();
        return toDomainList.convert(appointmentEntities);
    }
}
