package com.example.DentalClinic.service;

import com.example.DentalClinic.model.Patient;
import com.example.DentalClinic.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final IPatientRepository patientRepository;

    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> search(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchAll() {
        return patientRepository.findAll();
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }
}
