package com.example.DentalClinic.repository;

import com.example.DentalClinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long>{
}
