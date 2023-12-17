package com.example.DentalClinic.controller;

import com.example.DentalClinic.model.Appointment;
import com.example.DentalClinic.service.OdontologistService;
import com.example.DentalClinic.service.PatientService;
import com.example.DentalClinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private OdontologistService odontologistService;


    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        ResponseEntity<Appointment> response;
        if (patientService.search(appointment.getPatient().getId()).isPresent() && odontologistService.search(appointment.getOdontologist().getId()).isPresent())
            response = ResponseEntity.ok(appointmentService.saveAppointment(appointment));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> returnAppointments() {
        return ResponseEntity.ok(appointmentService.returnAppointments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointments (@PathVariable Long id) {
        ResponseEntity<String> response;
        if (appointmentService.search(id).isPresent()) {
            appointmentService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("The appointment has been deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.update(appointment));

    }
}

