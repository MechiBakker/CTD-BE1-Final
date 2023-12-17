package com.example.DentalClinic.service;

import com.example.DentalClinic.model.Odontologist;
import com.example.DentalClinic.service.OdontologistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologistServiceTest {

    @Autowired
    private OdontologistService odontologistService;


    public void registerDataSet(){

        this.odontologistService.saveOdontologist(new Odontologist("John", "Doe", "115.408"));
    }

    @Test
    public void registerOdontologist() {
        this.registerDataSet();
        Odontologist odontologist = odontologistService.saveOdontologist(new Odontologist("Jane", "Jones", "45.998"));
        Assert.assertTrue(odontologist.getId() != null);

    }

    @Test
    public void deleteOdontologistTest() {
        odontologistService.delete(1L);
        Assert.assertTrue(odontologistService.search(1L).isEmpty());

    }

    @Test
    public void returnOdontologistsTest() {
        List<Odontologist> odontologists = odontologistService.searchAll();;
        assertTrue(!odontologists.isEmpty());
        assertTrue(odontologists.size() == 1);
        System.out.println(odontologists);
    }
}