package com.example.DentalClinic.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.DentalClinic.model.Address;
import com.example.DentalClinic.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AddressService addressService;

    public void registerDataSet() {
        Address address1 = new Address("Calle 9", 1189, "La Plata", "Buenos Aires");
        Patient p = patientService.save(new Patient("Carusso", "Micaela", "36.588.973", "micarusso@gamil.com", new Date(), address1));
        Address address2 = new Address("Calle 5", 1466, "Miramar", "Buenos Aires");
        Patient p1 = patientService.save(new Patient("Allende", "María", "25.963.569", "marial@hotmail.com", new Date(), address2));

    }

    @Test
    public void setAndSearchPatientTest() {
        this.registerDataSet();
        Address address = new Address("Av.Colon", 2331, "Mar del Plata", "Buenos Aires");
        Patient p = patientService.save(new Patient("Felipe", "Recondo", "40.501.334", "feliperrpp@yahoo.com", new Date(), address));

        Assert.assertNotNull(patientService.search(p.getId()));
    }

    @Test
    public void deletePatientTest() {
        patientService.delete(3L);
        Assert.assertTrue(patientService.search(3L).isEmpty());

    }

    @Test
    public void returnAllTest() {
        List<Patient> patients = patientService.searchAll();
        Assert.assertTrue(!patients.isEmpty());
        Assert.assertTrue(patients.size() == 2);
            System.out.println(patients);
    }

}