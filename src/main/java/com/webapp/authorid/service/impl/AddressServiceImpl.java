package com.webapp.authorid.service.impl;

import com.webapp.authorid.entity.Address;
import com.webapp.authorid.entity.Author;
import com.webapp.authorid.payload.AddressDto;
import com.webapp.authorid.payload.AuthorDto;
import com.webapp.authorid.repository.AddressRepository;
import com.webapp.authorid.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = mapToEntity(addressDto);
        Address saved = addressRepository.save(address);
        AddressDto dto = mapToDto(address);
        return dto;
    }

    Address mapToEntity(AddressDto addressDto){
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setPinCode(addressDto.getPinCode());
        return address;
    }
    AddressDto mapToDto(Address address){
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setPinCode(address.getPinCode());
        return dto;

    }
}
