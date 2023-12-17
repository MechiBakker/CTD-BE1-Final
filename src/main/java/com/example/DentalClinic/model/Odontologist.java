package com.example.DentalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologists")
public class Odontologist {
    @Id
    @SequenceGenerator(name = "odontologist_seq", sequenceName = "odontologist_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologist_seq")
    private Long id;

    private String lastname;
    private String name;
    private String license;

    @OneToMany(mappedBy = "odontologist", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    public Odontologist() {

    }

    public Odontologist(String lastname, String name, String license) {
        this.lastname = lastname;
        this.name = name;
        this.license = license;
    }

    public Odontologist(Long id, String lastname, String name, String license) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Odontologist {" +
                "id=" + id +
                ", lastname ='" + lastname + '\'' +
                ", name ='" + name + '\'' +
                ", license ='" + license + '\'' +
                ", appointments =" + appointments +
                '}';
    }

}
