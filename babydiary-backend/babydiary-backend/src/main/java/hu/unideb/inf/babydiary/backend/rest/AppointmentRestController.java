package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.commons.pojo.request.AppointmentRequest;
import hu.unideb.inf.babydiary.service.api.domain.Appointment;
import hu.unideb.inf.babydiary.service.api.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.path.AppointmentPath.*;

@RestController
@RequiredArgsConstructor
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = APPOINTMENT_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.saveAppointment(appointmentRequest);
        return ResponseEntity.ok(appointmentRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = APPOINTMENT_GETONE)
    public ResponseEntity<?> getAppointmentBy(@PathVariable Long id) {
        Appointment appointment = appointmentService.findAppointmentById(id);
        return ResponseEntity.accepted().body(appointment);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = APPOINTMENT_GETALL)
    public ResponseEntity<?> getAll(){
        List<Appointment> appointmentList = appointmentService.findAllAppointment();
        return  ResponseEntity.accepted().body(appointmentList);
    }

}
