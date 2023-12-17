package com.example.DentalClinic.controller;

import com.example.DentalClinic.model.Patient;
import com.example.DentalClinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {

        return ResponseEntity.ok(patientService.save(patient));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchPatient(@PathVariable Long id) {
        Patient patient = patientService.search(id).orElse(null);

        return ResponseEntity.ok(patient);
    }

    @PutMapping()
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        ResponseEntity<Patient> response = null;

        if (patient.getId() != null && patientService.search(patient.getId()).isPresent())
            response = ResponseEntity.ok(patientService.update(patient));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (patientService.search(id).isPresent()) {
            patientService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("The patient has been correctly deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
