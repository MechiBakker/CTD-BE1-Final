package com.example.DentalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "appointments")

public class Appointment {

    @Id
    @SequenceGenerator(name="appointment_seq", sequenceName = "appointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appointment_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologist_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologist odontologist;
    private Date date;

    public Appointment() {

    }

    public Appointment(Patient patient, Odontologist odontologist, Date date) {
        this.patient = patient;
        this.odontologist = odontologist;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Odontologist getOdontologist() {
        return odontologist;
    }

    public void setOdontologist(Odontologist odontologist) {
        this.odontologist = odontologist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Appointment {" +
                "id =" + id +
                ", patient =" + patient +
                ", odontologist =" + odontologist +
                ", date =" + date +
                '}';
    }
}
