package com.example.DentalClinic.repository;

import com.example.DentalClinic.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long>{
}
