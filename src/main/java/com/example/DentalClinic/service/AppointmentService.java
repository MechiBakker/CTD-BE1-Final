package com.example.DentalClinic.service;

import com.example.DentalClinic.model.Appointment;
import com.example.DentalClinic.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppointmentService {

    private final IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> returnAppointments(){
        return appointmentRepository.findAll();
    }

    public void delete(Long id){
        appointmentRepository.deleteById(id);
    }

    public Appointment update(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> search(Long id){
        return appointmentRepository.findById(id);
    }
}
