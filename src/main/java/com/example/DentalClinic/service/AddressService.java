package com.example.DentalClinic.service;


import com.example.DentalClinic.model.Address;
import com.example.DentalClinic.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final IAddressRepository addressRepository;

    @Autowired
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address){
        addressRepository.save(address);
        return address;
    }
    public Optional<Address> search(Long id){
        return Optional.of(addressRepository.getOne(id));
    }
    public List<Address> addressList(){
        return addressRepository.findAll();
    }
    public void delete(Integer id){
        addressRepository.deleteById(Long.valueOf(id));
    }
}
