package com.example.DentalClinic.controller;

import com.example.DentalClinic.exceptions.BadRequestException;
import com.example.DentalClinic.exceptions.ResourceNotFoundException;
import com.example.DentalClinic.model.Odontologist;
import com.example.DentalClinic.service.OdontologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologists")
public class OdontologistController {

    @Autowired
    private OdontologistService odontologistService;

    @PostMapping
    public ResponseEntity<Odontologist> saveOdontologist(@RequestBody Odontologist odontologist)  {
        return ResponseEntity.ok(odontologistService.saveOdontologist(odontologist));

    }


    @GetMapping("/{id}")
    public ResponseEntity<Odontologist> search(@PathVariable Long id) throws ResourceNotFoundException {
        Odontologist odontologist = odontologistService.search(id).orElse(null);

        return ResponseEntity.ok(odontologist);
    }

    @PutMapping
    public ResponseEntity<Odontologist> updateOdontologist(@RequestBody Odontologist odontologist) throws BadRequestException, ResourceNotFoundException{
        ResponseEntity<Odontologist> response = null;
        if (odontologist.getId() != null && odontologistService.search(odontologist.getId()).isPresent())
            response = ResponseEntity.ok(odontologistService.update(odontologist));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologistService.search(id).isPresent()) {
            odontologistService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("The odontologist has been deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Odontologist>> searchAll(){
        return ResponseEntity.ok(odontologistService.searchAll());
    }
}
