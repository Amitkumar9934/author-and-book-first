package com.webapp.authorid.controller;

import com.webapp.authorid.entity.Address;
import com.webapp.authorid.payload.AddressDto;
import com.webapp.authorid.payload.AuthorDto;
import com.webapp.authorid.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping
    public ResponseEntity<AddressDto> createAuthor(@RequestBody AddressDto addressDto) {
        AddressDto dto= addressService.createAddress(addressDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
