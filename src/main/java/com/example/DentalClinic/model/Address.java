package com.example.DentalClinic.model;


import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long id;

    private String street;
    private int number;
    private String city;
    private String state;

    public Address() {

    }

    public Address(Long id, String street, int number, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Address(String street, int number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address {" +
                "id =" + id +
                ", street ='" + street + '\'' +
                ", number ='" + number + '\'' +
                ", city ='" + city + '\'' +
                ", state ='" + state + '\'' +
                '}';
    }
}
