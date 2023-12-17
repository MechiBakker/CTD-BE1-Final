package com.example.DentalClinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String lastname;
    private String name;
    private String dni;
    private String email;
    private Date dischargeDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();

    public Patient() {

    }

    public Patient(Long id, String lastname, String name, String dni, String email, Date dischargeDate, Address address) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.dischargeDate = dischargeDate;
        this.address = address;
    }

    public Patient(String lastname, String name, String dni, String email, Date dischargeDate, Address address) {
        this.lastname = lastname;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.dischargeDate = dischargeDate;
        this.address = address;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient {" +
                "id=" + id +
                ", lastname ='" + lastname + '\'' +
                ", name ='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", dischargeDate =" + dischargeDate +
                ", address =" + address +
                ", appointments =" + appointments +
                '}';
    }
}
