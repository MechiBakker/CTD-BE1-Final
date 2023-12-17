package com.example.DentalClinic.repository;

import com.example.DentalClinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long>{
}
