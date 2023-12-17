package com.example.DentalClinic.service;

import com.example.DentalClinic.model.Odontologist;
import com.example.DentalClinic.repository.IOdontologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class OdontologistService {

    private final IOdontologistRepository odontologistRepository;

    @Autowired
    public OdontologistService(IOdontologistRepository odontologistRepository) {
        this.odontologistRepository = odontologistRepository;
    }


    public Odontologist saveOdontologist (Odontologist odontologist) {
        return odontologistRepository.save(odontologist);
    }

    public void delete(Long id) {
        odontologistRepository.deleteById(id);
    }

    public Optional<Odontologist> search(Long id) {
        return odontologistRepository.findById(id);
    }

    public List<Odontologist> searchAll() {
        return odontologistRepository.findAll();
    }

    public Odontologist update(Odontologist odontologist) {
        return odontologistRepository.save(odontologist);
    }
}
